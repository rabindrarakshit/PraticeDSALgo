package com.algorithm.practice.dynamicprogramming.stock;

public class StockBuyAndSell1 {
    static int maxProfit(int[] arr){
        int maxProfit = 0;
        int minCost = arr[0];
        for(int i=1;i<arr.length;i++){
            maxProfit = Math.max(arr[i]-minCost, maxProfit);
            minCost = Math.min(minCost, arr[i]);
        }
        return maxProfit;
    }
}
