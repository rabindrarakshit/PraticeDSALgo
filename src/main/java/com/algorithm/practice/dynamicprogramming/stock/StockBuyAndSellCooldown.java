package com.algorithm.practice.dynamicprogramming.stock;

public class StockBuyAndSellCooldown {
    static int maxProfit(int[] prices, int k) {
        int days = prices.length;
        int[][] dp = new int[days + 2][2];
        // Index prices.length is just for base case
        for (int day = days - 1; day >= 0; day--) {
            for (int buy = 0; buy <= 1; buy++) {
                        if (buy == 0) {
                            // buy
                            dp[day][buy] = Math.max(0 + dp[day + 1][0], -prices[day] + dp[day + 1][1]);
                        } else {
                            // sell
                            dp[day][buy] = Math.max(0 + dp[day + 1][1], prices[day] + dp[day + 2][0]);
                        }
                    }
                }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;

        // Calculate and print the maximum profit
        System.out.println("The maximum profit that can be generated is " + maxProfit(prices, 2));
    }
}
