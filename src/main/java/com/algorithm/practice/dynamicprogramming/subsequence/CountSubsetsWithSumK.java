package com.algorithm.practice.dynamicprogramming.subsequence;

public class CountSubsetsWithSumK {
    static int subSets(int[] arr, int k){
        int length = arr.length;
        int dp[][] = new int[length][k+1];

        // Count 1 for all index with target 0
        for(int index=0;index<length;index++){
            dp[index][0] = 1;
        }

        // Count 1 for first index when value<=target
        // We put 1 because it's the first index and during back calculation if you end up with this target value on
        // first index then it would be a valid path
        if(arr[0]<=k)
            dp[0][arr[0]]= 1;

        for(int index=1; index<length;index++){
            for(int target =1; target<=k;target++){
                int notTake = dp[index-1][target];
                int take = 0;
                if(arr[index]<=target){
                    take = dp[index-1][target-arr[index]];
                }
                dp[index][target] = take+notTake;
            }
        }
         return dp[length-1][k];
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 2, 3};
        int k = 3;

        // Calculate and print the number of subsets that sum up to k
        System.out.println("The number of subsets found are " + subSets(arr, k));
    }
}
