package com.algorithm.practice.arrays.hard;

import java.util.HashMap;
import java.util.Map;

// Problem Statement: Given an array of integers A and an integer B. Find the total number of subarrays having bitwise
// XOR of all elements equal to k.

// Ref: https://takeuforward.org/data-structure/count-the-number-of-subarrays-with-given-xor-k/

// Time Complexity: O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array.
// Space Complexity: O(N) as we are using a map data structure.
public class MaxCountOfSubArrayWithXORK {

    static int maxCount(int[] arr, int target) {
        int xorC = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            xorC = xorC ^ arr[i];
            int xoRT = xorC ^ target;
            if (map.containsKey(xoRT)) {
                count = count + map.get(xoRT);
            }
            map.put(xorC, map.getOrDefault(xorC, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxCount(new int[]{4, 2, 2, 6, 4}, 6));
    }
}
