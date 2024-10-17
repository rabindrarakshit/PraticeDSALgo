package com.algorithm.practice.arrays.hard;

// Problem Statement: Given an array containing both positive and negative integers, we have to find the length of the
// longest subarray with the sum of all elements equal to zero.

// Ref: https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Time Complexity:
// Space Complexity:
public class MaximumSubArrayWithSumZero {

    static int maxLength(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = Integer.MIN_VALUE;
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum == 0) {
                maxLength = Math.max(maxLength, i + 1);
            } else {
                if (map.containsKey(sum)) {
                    maxLength = Math.max(i - map.get(sum), maxLength);
                } else {
                    map.put(sum, i);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
       // System.out.println(maxLength(new int[]{1, 2, 3, -3, -6, 6}));
        int[] test = new int[]{1,2};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(0,0);
        list.add(3);
        for(Integer i: list){
            System.out.println(i);
        }
    }
}
