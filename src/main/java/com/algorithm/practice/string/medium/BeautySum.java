package com.algorithm.practice.string.medium;

// Ref: https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/
// The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.
//
// For example, the beauty of "abaacc" is 3 - 1 = 2.
// Given a string s, return the sum of beauty of all of its substrings.

// Time Complexity: O(n^2)
// Space Complexity: O(1)

public class BeautySum {
    static int beautySum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int cnt[] = new int[26], max_f = 0, min_f = 0;
            for (int j = i; j < s.length(); j++) {
                int idx = s.charAt(j) - 'a';
                max_f = Math.max(max_f, ++cnt[idx]);
                if (min_f > cnt[idx] - 1) {
                    min_f = cnt[idx];
                } else if (min_f == cnt[idx] - 1) {
                    min_f = cnt[idx];
                    for (int k = 0; k < 26; ++k)
                        min_f = Math.min(min_f, cnt[k] == 0 ? Integer.MAX_VALUE : cnt[k]);
                }
                res += max_f - min_f;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(beautySum("aab"));
    }
}
