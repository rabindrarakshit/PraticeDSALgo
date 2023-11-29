package com.algorithm.practice.arrays;

public class MaxProfitBuySell2Times {
    static int maxProfit(int price[], int n) {
        int[] profit = new int[price.length];
        for (int i = 0; i < profit.length; i++) {
            profit[i] = 0;
        }
        int max = price[n-1];
        for(int i = n-2; i>=0;i--){
            if(price[i]>max)
                max = price[i];
            profit[i] = Math.max(profit[i+1], max - price[i]);
        }

        int min = price[0];
        for(int i=1; i<price.length;i++){
            if(price[i]<min){
                min = price[i];
            }
            profit[i] = Math.max(profit[i-1], profit[i]+(price[i]-min));
        }
        return profit[profit.length-1];
    }

    public static void main(String args[]) {
        int price[] = {2, 30, 15, 10, 8, 35, 80};
        int n = price.length;
        System.out.println("Maximum Profit = " + maxProfit(price, n));
    }
}
