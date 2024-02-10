package com.algorithm.practice.stack.monotonic;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Ref: https://leetcode.com/problems/next-greater-element-i/submissions/1170525297/
// Time: O(n+m)
// Space: O(n)

public class NextGreaterElement1 {
    static Map<Integer, Integer> nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                map.put(arr[i], stack.peek());
            } else {
                map.put(arr[i], -1);
            }
            stack.push(arr[i]);
        }
        return map;
    }

    static int[] nextGreaterElement1(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = nextGreaterElement(arr2);
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            result[i] = map.get(arr1[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{4, 1, 2};
        int[] arr2 = new int[]{1, 3, 4, 2};

        for (int i : nextGreaterElement1(arr1, arr2)) {
            System.out.print(i + " ");
        }
    }

}
