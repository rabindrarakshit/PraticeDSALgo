package com.algorithm.practice.dynamicprogramming.strings;

// Ref: https://takeuforward.org/data-structure/longest-common-substring-dp-27/

public class LongestCommonSubString {
    static int maxLengthMemOpt(String str1, String str2) {
        int prev[] = new int[str2.length() + 1];
        int current[] = new int[str2.length() + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    current[j] = 1 + prev[j - 1];
                    max = Math.max(current[j], max);
                } else {
                    current[j] = 0;
                }
            }
            prev = current.clone();
        }
        return max;
    }

    public static void main(String args[]) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Substring is " + maxLengthMemOpt(s1, s2));
    }
}
