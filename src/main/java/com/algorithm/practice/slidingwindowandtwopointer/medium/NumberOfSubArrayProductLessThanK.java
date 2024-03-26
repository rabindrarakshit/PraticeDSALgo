package com.algorithm.practice.slidingwindowandtwopointer.medium;

// Ref: https://leetcode.com/problems/subarray-product-less-than-k/description/

public class NumberOfSubArrayProductLessThanK {
    static int maxSubArray(int[] arr, int k) {
        if (k == 0)
            return 0;
        int cnt = 0;
        int prd = 1;

        for (int i = 0, j = 0; j < arr.length; j++) {
            prd = prd * arr[j];
            while (i <= j && prd >= k) {
                prd /= arr[i++];
            }
            cnt += (j - i + 1);
        }
        return cnt;
    }
}
