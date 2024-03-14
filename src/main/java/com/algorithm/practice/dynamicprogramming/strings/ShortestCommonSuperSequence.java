package com.algorithm.practice.dynamicprogramming.strings;

//Ref: https://takeuforward.org/data-structure/shortest-common-supersequence-dp-31/

public class ShortestCommonSuperSequence {
    static String shortestCommonSuperSequence(String str1, String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int len1 = 1; len1 <= length1; len1++) {
            for (int len2 = 1; len2 <= length2; len2++) {
                if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
                    dp[len1][len2] = 1 + dp[len1 - 1][len2 - 1];
                } else {
                    dp[len1][len2] = Math.max(dp[len1][len2 - 1], dp[len1 - 1][len2]);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        int len1 = length1;
        int len2 = length2;
        while (len1 > 0 && len2 > 0) {
            if (str1.charAt(len1 - 1) == str2.charAt(len2 - 1)) {
                result.append(str2.charAt(len2 - 1));
                len1--;
                len2--;
            } else {
                if (dp[len1 - 1][len2] > dp[len1][len2 - 1]) {
                    result.append(str1.charAt(len1 - 1));
                    len1--;
                } else {
                    result.append(str2.charAt(len2 - 1));
                    len2--;
                }
            }
        }
        while (len1 > 0) {
            result.append(str1.charAt(len1 - 1));
            len1--;
        }
        while (len2 > 0) {
            result.append(str2.charAt(len2 - 1));
            len2--;
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(shortestCommonSuperSequence("brute", "groot"));
    }
}

