package com.algorithm.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithGivenSum {

    //Brute Force
    public static void main(String[] args) {
        for (int i : subArrayWithGivenSumTwoPointer(new int[]{1, 2, 3, 4, 5}, 5)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : subArrayWithGivenSum(new int[]{1, 2, 3, 4, 5}, 5)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : subArrayWithGivenSumHashMap(new int[]{1, 2, 3, 4, 5}, 5)) {
            System.out.print(i + " ");
        }
    }

    static int[] subArrayWithGivenSum(int[] arr, int k) {
        int maxLength = 0;
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum == k) {
                    if (maxLength < (j - i + 1)) {
                        maxLength = j - i + 1;
                        result[0] = i;
                        result[1] = j;
                    }
                }
            }
        }
        return result;
    }

    static int[] subArrayWithGivenSumTwoPointer(int[] a, int k) {
        int n = a.length; // size of the array.

        int left = 0, right = 0; // 2 pointers
        long sum = a[0];
        int maxLen = 0;
        int[] result = new int[2];
        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= a[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                if (maxLen < right - left + 1) {
                    result[0] = left;
                    result[1] = right;
                }
                maxLen = Math.max(maxLen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += a[right];
        }

        return result;
    }

    static int[] subArrayWithGivenSumHashMap(int[] arr, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        int[] result = new int[2];

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                if (maxLength < i) {
                    result[0] = 0;
                    result[1] = i;
                }
                maxLength = Math.max(maxLength, i);
            }
            if (prefixSumMap.containsKey(sum - k)) {
                if (maxLength < (i - prefixSumMap.get(sum - k) + 1)) {
                    result[0] = prefixSumMap.get(sum - k) + 1;
                    result[1] = i;
                }
                maxLength = Math.max(maxLength, i - prefixSumMap.get(sum - k) + 1);
            }
            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
            }
        }
        return result;
    }
}
