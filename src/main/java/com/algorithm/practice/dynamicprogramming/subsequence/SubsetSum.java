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

    static boolean subSetSum(int[] arr, int index, int target, Boolean[][] dp) {
        if (target == 0) {
            return true;
        }
        if (index < 0 || target < 0) {
            return false;
        }
        if (dp[index][target] != null) {
            return dp[index][target];
        }
        boolean take = subSetSum(arr, index - 1, target - arr[index], dp);
        boolean notTake = subSetSum(arr, index - 1, target, dp);
        dp[index][target] = take || notTake;
        return dp[index][target];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        int indexes = arr.length - 1;
        int target = 4;
        Boolean[][] dp = new Boolean[indexes + 1][target + 1];
        System.out.println(subSetSum(arr, arr.length - 1, target, dp));
    }
}
