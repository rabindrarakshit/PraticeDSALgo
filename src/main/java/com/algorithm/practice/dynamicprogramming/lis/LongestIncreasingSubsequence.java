package com.algorithm.practice.dynamicprogramming.lis;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    static int longest(int[] prices) {
        int length = prices.length;
        int[][] dp = new int[length + 1][length];
        for (int day = prices.length - 1; day >= 0; day--) {
            for (int prev = day - 1; prev >= -1; prev--) {
                // not take
                int notTake = dp[day + 1][prev+1];
                int take = 0;
                // take
                if (prev==-1 || prices[day] > prices[prev]) {
                    take = 1 + dp[day + 1][day];
                }
                dp[day][prev+1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }

    static int longestAlternative(int[] prices){
        int[] indexes = new int[prices.length];
        Arrays.fill(indexes, 1);
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<i;j++){
                if(prices[j]<prices[i]){
                    indexes[i] = Math.max(indexes[j]+1, indexes[i]);
                }
            }
        }
        int max  = -1;
        for(int i: indexes){
            max = Math.max(i, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestAlternative(new int[]{8, 3, 4, 1, 7}));
    }
}
