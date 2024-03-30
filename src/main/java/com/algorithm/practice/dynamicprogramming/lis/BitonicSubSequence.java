package com.algorithm.practice.dynamicprogramming.lis;

//Ref:  https://takeuforward.org/data-structure/longest-bitonic-subsequence-dp-46/

import java.util.Arrays;

// time: O(n^2) | Space: O(2n)

public class BitonicSubSequence {
    static int longestBitonicSubsequence(int[] arr) {
        int[] incDP = new int[arr.length];
        int[] decDP = new int[arr.length];

        Arrays.fill(incDP, 1);
        Arrays.fill(decDP, 1);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && incDP[j] + 1 > incDP[i]) {
                    incDP[i] = incDP[j] + 1;
                }
                if (arr[j] > arr[i] && decDP[j] + 1 > decDP[i]) {
                    decDP[i] = decDP[j] + 1;
                }
            }
        }

        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(incDP[i] + decDP[i] - 1, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
        int n = arr.length;

        System.out.println("The length of the longest bitonic subsequence is " +
                longestBitonicSubsequence(arr));
    }
}
