package com.algorithm.practice.dynamicprogramming;

// Ref: https://takeuforward.org/data-structure/dynamic-programming-climbing-stairs/

import java.util.Arrays;

public class ClimbingStairs {

    // Time: O(2^n) | Memory: O(2^n)
    static int waysToClimbStairs(int stairs) {
        if (stairs == 1) {
            return 1;
        }
        if (stairs == 0) {
            return 1;
        }
        return waysToClimbStairs(stairs - 1) + waysToClimbStairs(stairs - 2);
    }

    static int waysToClimbStairsMemoization(int stairs) {
        int[] dp = new int[stairs + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        return waysToClimbStairsMemoization(stairs, dp);
    }

    static int waysToClimbStairsMemoization(int stairs, int[] dp) {
        if (dp[stairs] == -1) {
            dp[stairs] = waysToClimbStairsMemoization(stairs - 1, dp) + waysToClimbStairsMemoization(stairs - 2, dp);
        }
        return dp[stairs];
    }

    static int climbStairsTabulation(int stairs) {
        int prev1 = 1;
        int prev2 = 1;
        int current = 0;

        for (int i = 2; i <= stairs; i++) {
            current = prev1 + prev2;
            prev1 = prev2;
            prev2 = current;
        }
        return prev2;
    }

    public static void main(String[] args) {
        System.out.println(climbStairsTabulation(4));
    }
}
