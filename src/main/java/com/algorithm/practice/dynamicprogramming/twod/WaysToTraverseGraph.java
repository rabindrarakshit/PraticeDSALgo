package com.algorithm.practice.dynamicprogramming.twod;

import java.util.Arrays;

public class WaysToTraverseGraph {

    // Solution 1
    // Simple recursion
    // TIme : O(2^(m+n)) | Space: O(m+n)

    // Time: O(n*m) | Space : O(n*m)
    // Solution 2 (DP - Tabulation- Bottom-Up)
    static int ways(int m, int n) {
        int[][] ways = new int[m][n];
        for (int i = 0; i < n; i++) {
            ways[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            ways[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
            }
        }
        return ways[m - 1][n - 1];
    }

    // Solution 3
    // Optimized memory (DP)
    static int waysMemoryOptimized(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = 1;
        }
        for (int row = 1; row < m; row++) {
            int[] cur = new int[n];
            for (int col = 1; col < n; col++) {
                cur[0] = 1;
                cur[col] = cur[col - 1] + prev[col];
            }
            prev = cur;
        }
        return prev[n - 1];
    }

    //Basic Recursion
    static int waysrecursion(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        return waysrecursion(m - 1, n) + waysrecursion(m, n - 1);
    }

    static int waysrecursion2(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        return waysrecursion2(m - 1, n) + waysrecursion2(m, n - 1);
    }

    // Memoization
    static int waysDP(int m, int n, int[][] dp) {
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        dp[m][n] = waysrecursion(m - 1, n) + waysrecursion(m, n - 1);
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(waysMemoryOptimized(3, 3));
        System.out.println(waysrecursion(3, 3));
        System.out.println(waysrecursion2(2, 2));
        int[][] dp = new int[4][4];
        for (int i = 0; i < 4; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < 4; i++) {
            dp[i][0] = 1;
        }
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        System.out.println(waysDP(3, 3, dp));
    }

}
