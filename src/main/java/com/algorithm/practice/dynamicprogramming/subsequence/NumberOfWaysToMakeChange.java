package com.algorithm.practice.dynamicprogramming.subsequence;

// Ref: https://www.algoexpert.io/questions/number-of-ways-to-make-change
// Time: O(mn) | Space: O(n)

public class NumberOfWaysToMakeChange {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for (int i = 0; i < denoms.length; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - denoms[i] >= 0) {
                    ways[j] += ways[j - denoms[i]];
                }
            }
        }
        return ways[n];
    }

    static int ways(int[] arr, int target) {
        int length = arr.length;
        int[][] ways = new int[length][target + 1];

        for (int i = 0; i <= target; i++) {
            if (i % arr[0] == 0) {
                ways[0][i] = 1;
            }
        }
        for (int index = 1; index < length; index++) {
            for (int amt = 0; amt <= target; amt++) {
                int notTake = ways[index - 1][amt];
                int take = 0;
                if (arr[index] <= amt) {
                    take = ways[index][amt - arr[index]];
                }
                ways[index][amt] = take + notTake;
            }
        }
        return ways[length - 1][target];
    }
}
