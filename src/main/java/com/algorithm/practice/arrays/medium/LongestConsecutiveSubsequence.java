package com.algorithm.practice.arrays.medium;

import java.util.HashSet;
import java.util.Set;

// Problem Statement: You are given an array of ‘N’ integers.
// You need to find the length of the longest sequence which contains the consecutive elements.
// https://takeuforward.org/data-structure/longest-consecutive-sequence-in-an-array/

// Time Complexity: O(N)+O(2N) ~ O(N)


public class LongestConsecutiveSubsequence {
    static int longestSubsequence(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int i : arr) {
            set.add(i);
        }

        int longest = -1;
        for (int i : arr) {
            if (!set.contains(i - 1)) {
                int count = 1;
                int k = i;
                while (set.contains(k + 1)) {
                    count++;
                    k++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence(new int[]{7, 1, 2, 5, 3}));
    }
}
