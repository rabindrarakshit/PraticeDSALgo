package com.algorithm.practice.dynamicprogramming.partitionDP;

//Ref: https://takeuforward.org/data-structure/minimum-cost-to-cut-the-stick-dp-50/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumCostToCutStick {
    static int minimumCost(List<Integer> cuts, int n) {
        int c = cuts.size();
        Collections.sort(cuts);
        cuts.add(0, 0);
        cuts.add(n);
        int[][] dp = new int[c + 2][c + 2];
        for (int[] arr : dp)
            Arrays.fill(arr, -1);
        return minimumTabulation(cuts, n);
        //return minimumCostMemoDP(cuts, dp, 1, c);
        //return minimumCostRecursive(cuts, 1, c);
    }

    static int minimumCostRecursive(List<Integer> cuts, int i, int j) {
        if (i > j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int index = i; index <= j; index++) {
            int cost = (cuts.get(j + 1) - cuts.get(i - 1)) + minimumCostRecursive(cuts, i, index - 1) +
                    minimumCostRecursive(cuts, index + 1, j);
            min = Math.min(cost, min);
        }
        return min;
    }

    static int minimumCostMemoDP(List<Integer> cuts, int[][] dp, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int index = i; index <= j; index++) {
            int cost = (cuts.get(j + 1) - cuts.get(i - 1)) + minimumCostRecursive(cuts, i, index - 1) +
                    minimumCostRecursive(cuts, index + 1, j);
            min = Math.min(cost, min);
        }
        dp[i][j] = min;
        return min;
    }

    static int minimumTabulation(List<Integer> cuts, int rodLength) {
        Collections.sort(cuts);
        int c = cuts.size()-2;
        int[][] dp = new int[c + 2][c + 2];
        for (int i = c; i >= 1; i--) {
            for (int j = i; j <= c; j++) {
                int min = Integer.MAX_VALUE;
                for (int index = i; index <= j; index++) {
                    min = Math.min(min, cuts.get(j + 1) - cuts.get(i - 1) + dp[i][index - 1] + dp[index + 1][j]);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][c];
    }

    public static void main(String[] args) {
        ArrayList<Integer> cuts = new ArrayList<>(Arrays.asList(3, 5, 1, 4));
        int c = cuts.size();
        int n = 7;

        System.out.println("The minimum cost incurred: " + minimumCost(cuts, n));
    }
}
