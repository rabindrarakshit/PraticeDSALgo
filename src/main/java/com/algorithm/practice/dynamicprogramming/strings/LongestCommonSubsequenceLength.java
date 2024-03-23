package com.algorithm.practice.dynamicprogramming.strings;

// Ref: https://takeuforward.org/data-structure/longest-common-subsequence-dp-25/

import java.util.Arrays;

public class LongestCommonSubsequence {

    static int maxLengthMemo(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];
        for (int[] arr : dp) {
            Arrays.fill(dp, -1);
        }
        return maxLengthMemo(str1, str2, dp, str1.length() - 1, str2.length() - 1);
    }

    static int maxLengthMemo(String str1, String str2, int[][] dp, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (str1.charAt(i) == str2.charAt(j)) {
            dp[i][j] = 1 + maxLengthMemo(str1, str2, dp, i - 1, j - 1);
        } else {
            dp[i][j] = Math.max(maxLengthMemo(str1, str2, dp, i - 1, j), maxLengthMemo(str1, str2, dp, i, j - 1));
        }
        return dp[i][j];
    }

    static int maxLength(String str1, String str2) {
        int maxLength[][] = new int[str1.length() + 1][str2.length() + 1];
        // Let's represent str1 on y-axis
        for (int i = 0; i < str1.length(); i++) {
            maxLength[i][0] = 0;
        }
        // Let's represent str2 on x-axis
        for (int i = 0; i < str2.length(); i++) {
            maxLength[0][i] = 0;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                int match = 0;
                int notMatch = 0;
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    match = 1 + maxLength[i - 1][j - 1];
                } else {
                    notMatch = Math.max(maxLength[i - 1][j], maxLength[i][j - 1]);
                }
                maxLength[i][j] = Math.max(match, notMatch);
            }
        }
        return maxLength[str1.length()][str2.length()];
    }

    static int maxLengthMemOpt(String str1, String str2) {
        int prev[] = new int[str2.length() + 1];
        int current[] = new int[str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    current[j] = 1 + prev[j - 1];
                } else {
                    current[j] = Math.max(prev[j], current[j-1]);
                }
            }
            prev = current.clone();
        }
        return prev[str2.length()];
    }



    public static void main(String args[]) {
        String s1 = "acd";
        String s2 = "ced";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Subsequence is " + maxLength(s1, s2));
        System.out.println("The Length of Longest Common Subsequence is " + maxLengthMemOpt(s1, s2));
    }
}
