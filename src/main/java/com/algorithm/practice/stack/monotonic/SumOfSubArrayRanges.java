package com.algorithm.practice.stack.monotonic;

public class SumOfSubArrayRanges {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3};
        System.out.println(subArrayRanges(arr));
    }

    // Time: O(N)
    // Space: O(N)
    public static int subArrayRanges(int[] arr) {
        return SumOfSubArrayMax.sum(arr) - SumOfSubarrayMins.sumSubarrayMins(arr);
    }


    // Time: O(n^2)
    // Space: O(1)
    public long subArrayRangesBrute(int[] A) {
        long res = 0;
        for (int i = 0; i < A.length; i++) {
            int max = A[i], min = A[i];
            for (int j = i; j < A.length; j++) {
                max = Math.max(max, A[j]);
                min = Math.min(min, A[j]);
                res += max - min;
            }
        }
        return res;
    }
}
