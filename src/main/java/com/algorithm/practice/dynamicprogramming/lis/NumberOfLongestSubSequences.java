package com.algorithm.practice.dynamicprogramming.lis;

import java.util.Arrays;

// Ref: https://takeuforward.org/data-structure/number-of-longest-increasing-subsequences-dp-47/

public class NumberOfLongestSubSequences {
    static int numberOfLongestSubSequence(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ct = new int[arr.length];

        Arrays.fill(dp, 1);
        Arrays.fill(ct, 1);
        int max =1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[j] + 1 == dp[i]) {
                        ct[i] = ct[i] + ct[j];
                    }
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        ct[i] = ct[j];
                    }
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        int numberOfLongestSub = 0;
        for(int i=0; i< arr.length; i++){
            if(dp[i]==max) numberOfLongestSub+=ct[i];
        }

        return numberOfLongestSub;
    }

    static int findNumberOfLIS(int[] arr){

        int n = arr.length;

        int[] dp= new int[n];
        int[] ct= new int[n];

        Arrays.fill(dp,1);
        Arrays.fill(ct,1);

        int maxi = 1;

        for(int i=0; i<=n-1; i++){
            for(int prev_index = 0; prev_index <=i-1; prev_index ++){

                if(arr[prev_index]<arr[i] && dp[prev_index]+1>dp[i]){
                    dp[i] = dp[prev_index]+1;
                    //inherit
                    ct[i] = ct[prev_index];
                }
                else if(arr[prev_index]<arr[i] && dp[prev_index]+1==dp[i]){
                    //increase the count
                    ct[i] = ct[i] + ct[prev_index];
                }
            }
            maxi = Math.max(maxi,dp[i]);
        }

        int nos =0;

        for(int i=0; i<=n-1; i++){
            if(dp[i]==maxi) nos+=ct[i];
        }

        return nos;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{100,90,80,70,60,50,60,70,80,90,100}));
        System.out.println(numberOfLongestSubSequence(new int[]{100,90,80,70,60,50,60,70,80,90,100}));
    }
}
