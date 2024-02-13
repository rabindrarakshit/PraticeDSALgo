package com.algorithm.practice.stack.monotonic;

// Ref: https://takeuforward.org/data-structure/area-of-largest-rectangle-in-histogram/

import java.util.Stack;

public class MaxAreaHistogram {

    // Time: O(n^2)
    static int maxAreaBrute(int[] arr) {
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = i; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                maxArea = Math.max(maxArea, min * (j - i + 1));
            }
        }
        return maxArea;
    }

    // Time: O(2N)
    // Space: O(N)
    static int maxAreaMonotonicStack(int[] arr) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i <= arr.length; i++) {
            int cur = i >= arr.length ? Integer.MIN_VALUE : arr[i];
            while (stack.peek() != -1 && arr[stack.peek()] >= cur) {
                sum = Math.max(sum, arr[stack.pop()] * (i - stack.peek()-1));
            }
            stack.push(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maxAreaMonotonicStack(new int[]{3, 1, 3, 2, 2}));
        System.out.println(maxAreaMonotonicStack(new int[]{1,6,5}));
        System.out.println(maxAreaMonotonicStack(new int[]{1,6,5,6}));
        System.out.println(maxAreaMonotonicStack(new int[]{1,6,5,1}));
    }
}
