package com.algorithm.practice.dynamicprogramming;

import java.util.Arrays;

// Ref: https://takeuforward.org/data-structure/dynamic-programming-introduction/

public class Fibonacci {
    static int brute(int n) {
        if (n <= 1) {
            return n;
        }
        return brute(n - 1) + brute(n);
    }

    // top-down
    static int memoization(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return memoization(n, dp);
    }

    static int memoization(int n, int[] dp) {
        if (dp[n] == -1) {
            dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);
        }
        return dp[n];
    }

    static int tabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    static int tabulationMemoryOptimized(int n) {
        int prev = 0;
        int prev2 = 1;
        int cur = 0;
        for (int i = 2; i < n; i++) {
           cur=prev+prev2;
           prev = cur;
           prev2=prev;
        }
        return cur;
    }
}
