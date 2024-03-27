package com.algorithm.practice.dynamicprogramming.stock;

public class StockBuyAndSellWithTransactionFee {

    // Striver
    static int maxProfit(int[] prices, int fee) {
        int days = prices.length;
        int[][] dp = new int[days + 1][2];
        // Index prices.length is just for base case
        for (int day = days - 1; day >= 0; day--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) {
                    // buy
                    dp[day][buy] = Math.max(0 + dp[day + 1][0], -prices[day] + dp[day + 1][1]);
                } else {
                    // sell
                    dp[day][buy] = Math.max(0 + dp[day + 1][1], prices[day] + dp[day + 1][0] - fee);
                }
            }
        }
        return dp[0][0];
    }

    // Optimized/Hacky
    public int maxProfitOptimized(int[] prices, int fee) {
        int n = prices.length;
        int free = 0;
        int hold = -prices[0];
        for(int i = 1; i < prices.length; i++){
            free = Math.max(hold + prices[i] - fee, free);
            hold = Math.max(hold, free - prices[i]);
        }
        return free;
    }
}
