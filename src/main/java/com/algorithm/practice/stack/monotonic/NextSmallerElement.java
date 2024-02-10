package com.algorithm.practice.stack.monotonic;

import java.util.Stack;

// Ref: https://www.interviewbit.com/problems/nearest-smaller-element/
// Time: O(n)
// Space : O(n)

public class NextSmallerElement {
    static int[] nextSmallerElement(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i] = stack.peek();
            }else{
                result[i] = -1;
            }
            stack.push(nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        for(int i: nextSmallerElement(new int[]{1,2,3,4})){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int i: nextSmallerElement(new int[]{4,3,2,1})){
            System.out.print(i+" ");
        }
    }
}
