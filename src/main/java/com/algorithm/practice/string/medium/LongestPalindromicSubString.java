package com.algorithm.practice.string.medium;

// Ref: https://leetcode.com/problems/longest-palindromic-substring/description/
// Input: s = "babad"
// Output: "bab"
public class LongestPalindromicSubString {

    // Time Complexity: O(n^3)
    // Space Complexity : O(1)
    private static String longestNaive(String str) {
        String result = null;
        int maxLength = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                String subStr = str.substring(i, j + 1);
                if (isPalindrome(subStr) && subStr.length() > maxLength) {
                    maxLength = subStr.length();
                    result = subStr;
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left <= right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestNaive("ababc"));
        System.out.println(longestNaive("abc"));
    }
}
