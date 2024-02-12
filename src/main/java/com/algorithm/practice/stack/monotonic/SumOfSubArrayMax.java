package com.algorithm.practice.stack.monotonic;

import java.util.Stack;

public class SumOfSubArrayMax {
    public static int sum(int[] arr) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i2 = 0; i2 <= arr.length; i2++) {
            int cur = i2 < arr.length ? arr[i2] : Integer.MAX_VALUE;
            while (stack.peek() != -1 && cur > arr[stack.peek()]) {
                int index = stack.pop();
                int i1 = stack.peek();
                int left = index - i1;
                int right = i2 - index;
                int sum = left * right * arr[index];
                res += sum;
            }
            stack.push(i2);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[]{1, 2, 3}));
    }
}
