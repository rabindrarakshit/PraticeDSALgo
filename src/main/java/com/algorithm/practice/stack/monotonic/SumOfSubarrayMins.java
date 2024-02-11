package com.algorithm.practice.stack.monotonic;

import java.util.List;
import java.util.Stack;

// Ref: https://leetcode.com/problems/sum-of-subarray-minimums/description/

public class SumOfSubarrayMins {

    // This is wrong implementation for the above ref. It says the min should be for contagious arrays but here we
    // also consider non-contagious ones. For example: 1,2,3 we will also consider 1,3. Having said that this is the
    // correct implementation for SumOfAllSubArrayMins

    // Time: O((2^N)*k : size of lists)
    // Space: O(N)

    static Integer sum(int[] arr, int index, List<Integer> list, Integer sum) {
        if (index >= arr.length) {
            int min = Integer.MAX_VALUE;
            if (list.size() > 0) {
                for (int i : list) {
                    min = Math.min(min, i);
                }
            } else min = 0;
            sum = sum + min;
            return sum;
        }
        list.add(arr[index]);
        sum = sum(arr, index + 1, list, sum);
        list.remove(list.size() - 1);
        sum = sum(arr, index + 1, list, sum);
        return sum;
    }

    // Time: O(2N)
    // Space: O(N)
    // leetcode 43 ms
    public static int sumSubarrayMins(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        long res = 0;
        long M = (long) 1e9 + 7;
        stack.push(-1);
        for (int i2 = 0; i2 <= arr.length; i2++) {
            int cur = i2 < arr.length ? arr[i2] : 0;
            while (stack.peek() != -1 && cur < arr[stack.peek()]) {
                int index = stack.pop();
                int i1 = stack.peek();
                int left = index - i1;
                int right = i2 - index;
                long curSum = (left * right * (long) arr[index]) % M;
                res = (res + curSum) % M;
            }
            stack.push(i2);
        }
        return (int)res;
    }


    // leetcode : 8ms
    // Need to check later. Does not use monotonic stack
    public int sumSubarrayMins2(int[] arr) {
        int mod = (int) 1e9 + 7;
        int n = arr.length + 1;
        int[] left = new int[n];
        int[] ext = new int[n];
        int[] sums = new int[n];

        for (int i = 0; i < n-1; i++) {
            ext[i + 1] = arr[i];
        }
        int res = 0;

        for (int i = 1; i < n; i++) {
            int cur = ext[i]; // 3
            int l = i-1; //0
            while(ext[l]>=cur){ //0>=3
                l = left[l];
            }
            left[i] = l;
            sums[i] = sums[l] +cur * (i - l);
            res = (res +sums[i]) % mod;
        }
        return res;
    }

    public static void main(String[] args) {
        // System.out.println(sum(new int[]{3, 1, 2, 4}, 0, new ArrayList<>(), 0));
        System.out.println(sumSubarrayMins(new int[]{3, 1, 2, 4}));
    }
}
