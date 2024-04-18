package com.algorithm.practice.dynamicprogramming.oned;

// https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/

import java.util.Arrays;

public class FrogJumpMinEnergy {

    static int minEnergy(int[] heights, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return Math.abs(heights[1] - heights[0]);
        }
        int jumpOne = Math.abs(heights[n] - heights[n - 1]) + minEnergy(heights, n - 1);
        int jumpTwo = Math.abs(heights[n] - heights[n - 2]) + minEnergy(heights, n - 2);
        return Math.min(jumpOne, jumpTwo);
    }

    static int minEnergy(int[] heights, int n, int[] dp) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return Math.abs(heights[1] - heights[0]);
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int jumpOne = Math.abs(heights[n] - heights[n - 1]) + minEnergy(heights, n - 1, dp);
        int jumpTwo = Math.abs(heights[n] - heights[n - 2]) + minEnergy(heights, n - 2, dp);
        dp[n] = Math.min(jumpOne, jumpTwo);
        return dp[n];
    }

    static int minEnergyTabu(int[] heights) {
        int[] dp = new int[heights.length + 1];
        dp[0] = 0;
        dp[1] = Math.abs(heights[1] - heights[0]);
        for (int i = 2; i < heights.length; i++) {
            int jumpOne = Math.abs(heights[i] - heights[i - 1]) + dp[i - 1];
            int jumpTwo = Math.abs(heights[i] - heights[i - 2]) + dp[i - 2];
            dp[i] = Math.min(jumpOne, jumpTwo);
        }
        return dp[heights.length-1];
    }

    static int minJumps(int[] heights) {
        int prev0 = 0;
        int prev = 0;
        int current = 0;
        int stairs = heights.length;

        for (int i = 1; i < stairs; i++) {
            int jump2 = Integer.MAX_VALUE;
            int jump1 = prev + Math.abs(heights[i] - heights[i - 1]);
            if (i > 1) {
                jump2 = prev0 + Math.abs(heights[i] - heights[i - 2]);
            }
            current = Math.min(jump2, jump1);
            prev0 = prev;
            prev = current;
        }
        return prev;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{30, 10, 60, 10, 60, 50};
        System.out.println(minJumps(heights));
        System.out.println(minEnergy(heights, heights.length - 1));
        int[] dp = new int[heights.length + 1];
        Arrays.fill(dp, -1);
        System.out.println(minEnergy(heights, heights.length - 1, dp));
        System.out.println(minEnergyTabu(heights));
    }
}
