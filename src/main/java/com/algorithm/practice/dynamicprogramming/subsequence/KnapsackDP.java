package com.algorithm.practice.dynamicprogramming.subsequence;

import java.util.Arrays;

public class KnapsackDP {
    static int maxValue(int[] value, int[] weight, int w) {
        int[][] dp = new int[value.length][w + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return memo(value, weight, w, dp, value.length - 1);
    }

    static int memo(int[] value, int[] weight, int w, int[][] dp, int index) {
        if (index == 0) {
            if (weight[index] <= w) {
                return value[index];
            } else {
                return 0;
            }
        }
        if (dp[index][w] != -1) {
            return dp[index][w];
        }

        int notTake = memo(value, weight, w, dp, index - 1);
        int take = 0;
        if (weight[index] <= w) {
            take = value[index] + memo(value, weight, w - weight[index], dp, index - 1);
        }
        dp[index][w] = Math.max(take, notTake);
        return dp[index][w];
    }

    static int maxValueTabular(int[] weights, int[] values, int w) {
        int items = weights.length;
        int[][] dp = new int[items][w + 1];

        for (int weight = weights[0]; weight < w; weight++) {
            dp[0][weight] = values[0];
        }

        for (int item = 1; item < items; item++) {
            for (int weight = 0; weight <= w; weight++) {
                int notTake = dp[item - 1][weight];
                int take = 0;
                if (weights[item] <= weight) {
                    take = values[item] + dp[item - 1][weight - weights[item]];
                }
                dp[item][weight] = Math.max(take, notTake);
            }
        }

        return dp[items - 1][w];
    }


    public static void main(String[] args) {
        int wt[] = {1, 2, 4, 5};
        int val[] = {5, 4, 8, 6};
        int W = 5;

        // Calculate and print the maximum value of items the thief can steal
        System.out.println("The Maximum value of items the thief can steal is " + maxValue(val, wt, W));
    }
}
