package com.algorithm.practice.arrays;

import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.Stack;

public class StockSpan {
    static int[] findSpanBruteForce(int[] arr) {
        int[] result = new int[arr.length];
        result[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int count = 1;
            for (int j = i - 1; j >= 0 && arr[j] < arr[i]; j--) {
                count++;
            }
            result[i] = count;
        }
        return result;
    }

    static int[] findSpanUsingStack(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        result[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = i + 1;
            } else {
                result[i] = i - stack.peek();
            }
            stack.push(i);
        }
        return result;
    }

    static int[] findSpanWithoutStack(int[] arr) {
        int result[] = new int[arr.length];
        result[0] = 1;
        for (int i = 1; i <= result.length; i++) {
            int count = 1;
            while (i - count > 0 && arr[i] >= arr[i - count]) {
                count = count + result[i - count];
            }
            result[i]=count;
        }
        return result;
    }

    public static void main(String[] args) {
        int price[] = {10, 4, 5, 90, 120, 80};
        for (int i : findSpanUsingStack(price))
            System.out.println(i);
    }
}
