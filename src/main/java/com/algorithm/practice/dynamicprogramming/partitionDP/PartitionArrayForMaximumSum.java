package com.algorithm.practice.dynamicprogramming.partitionDP;

//Ref: https://takeuforward.org/data-structure/partition-array-for-maximum-sum-front-partition-dp-54/

public class PartitionArrayForMaximumSum {
    static int maxSum(int[] arr, int k) {
        return maxSumRecur(arr, k, 0);
    }

    static int maxSumRecur(int[] arr, int k, int index) {
        int n = arr.length;
        if (index == n) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int len = 0;
        int maxSum = 0;
        for (int i = index; i < Math.min(index + k, n); i++) {
            max = Math.max(max, arr[i]);
            len++;
            maxSum = Math.max(maxSum, len * max + maxSumRecur(arr, k, i + 1));
        }
        return maxSum;
    }

    static int maxSumRecurDP(int[] arr, int k, int index) {
        int n = arr.length;
        if (index == n) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int len = 0;
        int maxSum = 0;
        for (int i = index; i < Math.min(index + k, n); i++) {
            max = Math.max(max, arr[i]);
            len++;
            maxSum = Math.max(maxSum, len * max + maxSumRecur(arr, k, i + 1));
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] num = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        int maxSum = maxSum(num, k);
        System.out.println("The maximum sum is: " + maxSum);
    }
}
