package com.algorithm.practice.dynamicprogramming.subsequence;

import java.util.Arrays;

// Ref: https://takeuforward.org/data-structure/partition-equal-subset-sum-dp-15/

public class PartitionEqualSubsetSum {
    static boolean partitionSubset(int[] arr) {
        int length = arr.length;
        int sum = Arrays.stream(arr).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int pSum = sum/2;
        boolean[][] dp = new boolean[length][pSum+1];
        for(int index=0;index<length;index++){
            dp[index][0] = true;
        }
        if(arr[0]<=pSum){
            dp[0][arr[0]]=true;
        }

        for(int index=1;index<length;index++){
            for(int target = 1;target<=pSum;target++){
                boolean notTake = dp[index-1][target];
                boolean take = false;
                if(arr[index]<=target){
                    take = dp[index-1][target-arr[index]];
                }
                dp[index][target] = take || notTake;
            }
        }

        return dp[length-1][pSum];
    }

    public static void main(String[] args) {
        System.out.println(partitionSubset(new int[]{2, 3, 3, 3, 4, 5}));
    }
}
