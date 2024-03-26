package com.algorithm.practice.dynamicprogramming.stock;

//Ref: https://takeuforward.org/data-structure/buy-and-sell-stock-ii-dp-36/

public class StockBuyAndSell2 {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n + 1][2];
        dp[n][0] = dp[n][1] = 0;
        int profit = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[ind + 1][0], -arr[ind] + dp[ind + 1][1]);
                }
                else{
                    profit = Math.max(0 + dp[ind + 1][1], arr[ind] + dp[ind + 1][0]);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][0];
    }
}
