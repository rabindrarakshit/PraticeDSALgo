package com.algorithm.practice.stack.monotonic;

import java.util.Stack;

public class NextGreaterElementCircularArray {

    static int[] nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] result = new int[n];
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i % n] > stack.peek()) {
                stack.pop();
            }
            if (i < n) {
                if (!stack.isEmpty()) {
                    result[i] = stack.peek();
                }
            }
            stack.push(arr[i % n]);
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
