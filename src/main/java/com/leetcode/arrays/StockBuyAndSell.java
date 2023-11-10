package com.leetcode.arrays;

public class StockBuyAndSell {
    public static int maximumProfit(int[] arr) {
        int minPrice = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            minPrice = Math.min(arr[i], minPrice);
            maxDiff = Math.max(maxDiff, arr[i] - minPrice);
        }

        return maxDiff;
    }

    public static void main(String[] args) {
        int arr[] = {7,1,5,3,6,4};

        int maxPro = maximumProfit(arr);
        System.out.println("Max profit is: " + maxPro);
    }
}
