package com.algorithm.practice.dynamicprogramming.partitionDP;

import java.util.Arrays;

// Ref: https://takeuforward.org/dynamic-programming/matrix-chain-multiplication-dp-48/
// Ref: https://takeuforward.org/data-structure/matrix-chain-multiplication-tabulation-method-dp-49/

/*
* Time Complexity: O(N*N*N)

Reason: There are N*N states and we explicitly run a loop inside the function which will run for N times,
* therefore at max ‘N*N*N’ new problems will be solved.

Space Complexity: O(N*N)

Reason: We are using a 2D array ( O(N*N)) space.
* */

public class MCM {
    static int mcm(int[] array, int i, int j) {
        if (i == j) {
            return 0;
        }
        int minOp = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int operations = array[i - 1] * array[k] * array[j] + mcm(array, i, k) + mcm(array, k + 1, j);
            minOp = Math.min(operations, minOp);
        }
        return minOp;
    }

    static int mcmMemoDP(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        return mcmMemoDP(arr, dp, 1, arr.length - 1);
    }

    static int mcmMemoDP(int[] array, int[][] dp, int i, int j) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (i == j) {
            return 0;
        }
        int minOp = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int operations = array[i - 1] * array[k] * array[j] + mcm(array, i, k) + mcm(array, k + 1, j);
            minOp = Math.min(operations, minOp);
        }
        dp[i][j] = minOp;
        return dp[i][j];
    }

    static int mcmTabuDP(int[] array) {
        int[][] dp = new int[array.length][array.length];
        int n = array.length;
        for (int i = 0; i < array.length; i++) {
            dp[i][i] = 0;
        }

        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int operations = array[i - 1] * array[k] * array[j] + dp[i][k] + dp[k + 1][j];
                    min = Math.min(operations, min);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n - 1];
    }

    public static void main(String[] args) {
        int[] input = new int[]{10, 20, 30, 40, 50};
        System.out.println(mcm(input, 1, input.length - 1));
        System.out.println(mcmMemoDP(input));
        System.out.println(mcmTabuDP(input));
    }
}
