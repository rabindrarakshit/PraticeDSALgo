package com.algorithm.practice.arrays.medium;

// Stocks one time sell
public class MaxDiff2ElementsLargerAfterSmaller {
    static int maxDiff(int[] arr) {
        int min = arr[0];
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - min > diff) {
                diff = arr[i] - min;
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        System.out.println(maxDiff(new int[]{5, 4, 3, 9}));
    }
}
