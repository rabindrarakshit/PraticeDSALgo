package com.algorithm.practice.dynamicprogramming.subsequence;

//ref: https://takeuforward.org/data-structure/subset-sum-equal-to-target-dp-14/
// Time: O(index*target) | Space: O(index*target)

public class SubsetSum {
    static boolean isSubsetPresent(int[] arr, int k){
        int rows = arr.length;
        boolean[][] dp = new boolean[rows][k+1];

        for(int row=0;row<rows;row++){
            dp[row][0]= true;
        }
        if(arr[0]<=k){
            dp[0][arr[0]]= true;
        }

        for(int row=1;row<rows;row++){
            boolean take = false;
            boolean notTake = false;
            for(int target = 1;target<=k;target++){
                notTake = dp[row-1][target];
                if(arr[row]<=target){
                    take = dp[row-1][target-arr[row]];
                }
                dp[row][target] = take || notTake;
            }
        }
        return dp[rows-1][k];
    }
}
