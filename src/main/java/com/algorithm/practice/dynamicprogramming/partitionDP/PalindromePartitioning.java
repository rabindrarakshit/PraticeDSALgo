package com.algorithm.practice.dynamicprogramming.partitionDP;

// Ref:https://takeuforward.org/data-structure/palindrome-partitioning-ii-front-partition-dp-53/

import java.util.Arrays;

public class PalindromePartitioning {
    static boolean isPalindrome(String str, int i, int j) {
        while (i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // Both memo and tabu took approx 2540 s
    static int minPartitions(String str) {
        int[] dp = new int[str.length()];
        Arrays.fill(dp, -1);
        return minPartitionsDP(str, 0, str.length(), dp) - 1;
        //return minPartitionsRecur(str, 0, str.length());
    }

    static int minPartitionsRecur(String str, int i, int j) {
        if (i == j) return 0;
        int minPartitions = Integer.MAX_VALUE;
        for (int index = i; index < j; index++) {
            if (isPalindrome(str, i, index)) {
                minPartitions = Math.min(minPartitions, 1 + minPartitionsRecur(str, index + 1, j));
            }
        }
        return minPartitions - 1;
    }

    static int minPartitionsDP(String str, int i, int j, int[] dp) {
        if (i == j) return 0;
        if (dp[i] != -1) {
            return dp[i];
        }
        int minPartitions = Integer.MAX_VALUE;
        for (int index = i; index < j; index++) {
            if (isPalindrome(str, i, index)) {
                minPartitions = Math.min(minPartitions, 1 + minPartitionsDP(str, index + 1, j, dp));
            }
        }
        dp[i] = minPartitions;
        return minPartitions;
    }

    public static void main(String[] args) {
        System.out.println(minPartitions("bb"));
    }


    // Optimised soln leetcode : 18ms
    public int minCut(String s) {
        char[] seq = s.toCharArray();
        int n = seq.length;
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; ++i) {
            dp[i] = i - 1;
        }

        for (int i = 1; i <= n; ++i) {
            int lo = i - 1;
            int prev = dp[i - 1];
            dp[i] = Math.min(dp[i], prev + 1);

            while (i < n && seq[i] == seq[i - 1]) {
                i++;
                prev = Math.min(prev, dp[i - 1]);
                dp[i] = Math.min(dp[i], prev + 1);
            }

            int hi = i + 1;
            while (lo > 0 && hi <= n && seq[lo - 1] == seq[hi - 1]) {
                dp[hi] = Math.min(dp[hi], dp[lo - 1] + 1);
                lo--;
                hi++;
            }
        }
        return dp[n];
    }
}
