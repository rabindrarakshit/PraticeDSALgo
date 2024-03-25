package com.algorithm.practice.dynamicprogramming.strings;

import java.util.Arrays;

//Ref: https://takeuforward.org/data-structure/print-longest-common-subsequence-dp-26/

public class LCSPrintString {
    // By storing sequences in DP table
    // This has a bit more storage but its efficient on time
    static String maxMemOpt(String str1, String str2) {
        StringBuilder prev[] = new StringBuilder[str2.length() + 1];
        StringBuilder current[] = new StringBuilder[str2.length() + 1];

        Arrays.fill(prev, new StringBuilder());
        Arrays.fill(current, new StringBuilder());

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    current[j] = prev[j - 1].append(str1.charAt(i - 1));
                } else {
                    current[j] = prev[j].length() >= current[j - 1].length() ? prev[j] : current[j - 1];
                }
            }
            prev = current.clone();
        }
        return prev[str2.length()].toString();
    }

    //This is the alternate way where we first calculate the max length on the DP table and then we again
    // backtrack the DP table and form the result string
    // This uses less memory but uses additional time for the extra backtrack

    static String longestCS(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int dp[][] = new int[length1 + 1][length2 + 1];

        for (int len1 = 1; len1 <= length1; len1++) {
            for (int len2 = 1; len2 <= length2; len2++) {
                if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
                    dp[len1][len2] = 1 + dp[len1 - 1][len2 - 1];
                } else {
                    dp[len1][len2] = Math.max(dp[len1 - 1][len2], dp[len1][len2 - 1]);
                }
            }
        }
        int maxLength = dp[length1][length2];
        int len1 = length1;
        int len2 = length2;
        char[] result = new char[maxLength];
        maxLength--;
        while (len1 > 0 && len2 > 0) {
            if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
                result[maxLength--] = str1.charAt(len1 - 1);
                len1--;
                len2--;
            } else {
                if (dp[len1 - 1][len2] >= dp[len1][len2 - 1]) {
                    len1--;
                } else {
                    len2--;
                }
            }
        }
        return String.valueOf(result);
    }

    public static void main(String args[]) {
        String s1 = "acd";
        String s2 = "ced";

        // Call the lcs function and print the result
        System.out.println("The Longest Common Subsequence is " + maxMemOpt(s1, s2));
        System.out.println("The Longest Common Subsequence is " + longestCS(s1, s2));
    }
}
