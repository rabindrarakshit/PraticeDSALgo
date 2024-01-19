package com.algorithm.practice.string.medium;

// Ref: https://leetcode.com/problems/longest-palindromic-substring/description/
// Input: s = "babad"
// Output: "bab"
public class LongestPalindromicSubString {

    // Time Complexity: O(n^3)
    // Space Complexity : O(1)
    private static String longestNaive(String str) {
        String result = String.valueOf(str.charAt(0));
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

    // Time Complexity: O(n^2)
    // Space Complexit: O(1)
    private static String longestExpandFromCenter(String str) {
        String maxStr = str.substring(0, 1);
        for (int i = 0; i < str.length(); i++) {
            // for odd
            String oddStr = getPalindromeSubStr(str, i, i);
            if (oddStr.length() > maxStr.length()) {
                maxStr = oddStr;
            }

            // for even
            String evenStr = getPalindromeSubStr(str, i, i + 1);
            if (evenStr.length() > maxStr.length()) {
                maxStr = evenStr;
            }
        }
        return maxStr;
    }

    private static String getPalindromeSubStr(String str, int left, int right) {
        while (left >= 0 && right < str.length()) {
            if (str.charAt(left) != str.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return str.substring(left + 1, right);
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

        System.out.println(longestExpandFromCenter("ababc"));
        System.out.println(longestExpandFromCenter("abc"));
    }
}
