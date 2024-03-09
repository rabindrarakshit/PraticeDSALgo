package com.algorithm.practice.dynamicprogramming.stock;

// Ref: https://takeuforward.org/data-structure/buy-and-sell-stock-iii-dp-37/

public class StockBuyAndSell3 {

    // In memoization/recursion we take n as the base case which cannot be achieved here with valid indexes.
    // So we use 1-based indexing and represent the real indexes as index-1 and size as n+1
    static int maxProfit(int[] prices, int k) {
        int days = prices.length;
        int[][][] dp = new int[days+1][2][k+1];
        // Index prices.length is just for base case
        for (int day = days - 1; day >= 0; day--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int capacity = 1; capacity <= k; capacity++) {
                    if (buy == 0) {
                        // buy
                        dp[day][buy][capacity] = Math.max(0 + dp[day + 1][0][capacity], -prices[day] + dp[day + 1][1][capacity]);
                    } else {
                        // sell
                        dp[day][buy][capacity] = Math.max(0 + dp[day + 1][1][capacity], prices[day] + dp[day + 1][0][capacity - 1]);
                    }
                }
            }
        }
        // Day 0 buy and capacity 2
        return dp[0][0][k];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;

        // Calculate and print the maximum profit
        System.out.println("The maximum profit that can be generated is " + maxProfit(prices,2));
    }
}
