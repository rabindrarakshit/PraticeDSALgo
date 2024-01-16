package com.algorithm.practice.arrays.hard;

// Problem Statement: Given an array that contains both negative and positive integers, find the maximum product subarray.
// Ref: https://takeuforward.org/data-structure/maximum-product-subarray-in-an-array/

// Time Complexity: O(N)
//
//Space Complexity: O(1)
public class MaximumProductSubarray {
    static int maxProductKadane(int[] arr) {
        int prodMin = arr[0], prodMax = arr[0], result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int temp = Math.max(arr[i], Math.max(prodMin * arr[i], prodMax * arr[i]));
            prodMin = Math.min(arr[i], Math.min(prodMax * arr[i], prodMin * arr[i]));
            prodMax = temp;
            result = Math.max(prodMax, result);
        }
        return result;
    }

    static int maxProduct(int[] arr) {
        int product = 1;
        int suffixP = 1;
        int prefixP = 1;
        int low = 0;
        int high = arr.length - 1;
        while (low < arr.length && high >= 0) {
            if (prefixP == 0) {
                prefixP = 1;
            }
            if (suffixP == 0) {
                suffixP = 1;
            }
            prefixP = prefixP * arr[low];
            suffixP = suffixP * arr[high];
            product = Math.max(product, Math.max(prefixP, suffixP));
            low++;
            high--;
        }
        return product;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 0, -4, -5};
        int answer1 = maxProduct(arr);
        int answer2 = maxProductKadane(arr);
        System.out.println("The maximum product subarray is: " + answer1 + " " + answer2);
    }
}
