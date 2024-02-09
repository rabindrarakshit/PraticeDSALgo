package com.algorithm.practice.stack.monotonic;

import java.util.Stack;

public class NextGreaterElementNonCircularArray {
    static int[] nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            } else {
                result[i] = -1;
            }
            stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {5, 7, 1, 2, 6, 0};

        int arr2[] = nextGreaterElement(arr);
        System.out.println("The next greater elements are ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
    }
}
