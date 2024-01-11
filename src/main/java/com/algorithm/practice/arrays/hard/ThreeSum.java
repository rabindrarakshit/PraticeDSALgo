package com.algorithm.practice.arrays.hard;

// Problem Statement: Given an array of N integers, your task is to find unique triplets that add up to give a
// sum of zero. In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]]
// such that i!=j, j!=k, k!=i, and their sum is equal to zero.

// https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero/

// Naive : 3 loops
// Better: 2 loops + hashmap containing elements between i to j
// Optimized
// Time Complexity: O(NLogN)+O(N^2)
// Space Complexity: O(1)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    static List<List<Integer>> findTriplets(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            //skip the duplicates:
            if (i != 0 && arr[i] == arr[i - 1]) continue;

            int first = i;
            int second = i + 1;
            int third = n - 1;

            while (second < third) {
                int sum = arr[first] + arr[second] + arr[third];
                if (sum < 0) {
                    second++;
                } else if (sum > 0) {
                    third--;
                } else {
                    res.add(List.of(arr[first], arr[second], arr[third]));
                    second++;
                    third--;
                    //skip the duplicates:
                    while (arr[second] == arr[second - 1]) second++;
                    while (arr[third] == arr[third + 1]) third--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        findTriplets(new int[]{1, 2, 4, 5, -3, -9}).forEach(list -> list.forEach(ele -> System.out.print(ele + " ")));
    }
}
