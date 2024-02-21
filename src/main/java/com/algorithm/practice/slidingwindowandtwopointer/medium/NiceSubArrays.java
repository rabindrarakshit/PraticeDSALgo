package com.algorithm.practice.slidingwindowandtwopointer.medium;

//Ref: https://leetcode.com/problems/count-number-of-nice-subarrays/description/
public class NiceSubArrays {
    static int niceSubArrays(int[] arr, int k) {
        return atMost(arr, k) - atMost(arr, k - 1);
    }

    static int atMost(int[] arr, int k) {
        int res = 0, i = 0;
        for (int j = 0; j < arr.length; j++) {
            k -= arr[j] % 2;
            while (k < 0)
                k += arr[i++] % 2;
            res += (j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(niceSubArrays(new int[]{1,1,2,1,1}, 3));
    }
}
