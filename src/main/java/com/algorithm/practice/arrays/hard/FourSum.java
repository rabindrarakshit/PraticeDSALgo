package com.algorithm.practice.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Problem Statement: Given an array of N integers, your task is to find unique quads that add up to give a target
// value. In short, you need to return an array of all the unique quadruplets [arr[a], arr[b], arr[c], arr[d]]
// such that their sum is equal to a given target.

// Ref: https://takeuforward.org/data-structure/4-sum-find-quads-that-add-up-to-a-target-value/

public class FourSum {
    // naive
    // Time Complexity : O(N^4)
    static Set<List<Integer>> findFourSum(int[] arr, int target) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    for (int l = k + 1; l < arr.length; l++) {
                        sum = sum + arr[i] + arr[j] + arr[k] + arr[l];
                        if (sum == target) {
                            set.add(List.of(arr[i], arr[j], arr[k], arr[l]));
                        }
                    }
                }
            }
        }
        return set;
    }

    // Better Using Hashset
    // We will not do that here

    // Optimized
    // Here we have used Set you can also remove it and skip the duplicates
    // Time Complexity : O(NLogN) +O(NlogN) Insertion in a Set is Log(N)
    static Set<List<Integer>> findFourSumOptimized(int[] arr, int target) {
        Arrays.sort(arr);

        Set<List<Integer>> set = new HashSet<>();
        for (int first = 0; first < arr.length - 4; first++) {
            int second = first + 1, third = second + 1, fourth = arr.length - 1;
            while (third < fourth) {
                int sum = arr[first] + arr[second] + arr[third] + arr[fourth];
                if (sum < target) {
                    third++;
                } else if (sum > target) {
                    fourth--;
                } else {
                    set.add(List.of(arr[first], arr[second], arr[third], arr[fourth]));
                    third++;
                    fourth--;
                }
            }
        }
        return set;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length; // size of the array
        List<List<Integer>> ans = new ArrayList<>();

        // sort the given array:
        Arrays.sort(nums);

        // calculating the quadruplets:
        for (int i = 0; i < n; i++) {
            // avoid the duplicates while moving i:
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                // avoid the duplicates while moving j:
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // 2 pointers:
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        // skip the duplicates:
                        while (k < l && nums[k] == nums[k - 1]) k++;
                        while (k < l && nums[l] == nums[l + 1]) l--;
                    } else if (sum < target) k++;
                    else l--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        for (List<Integer> integers : findFourSumOptimized(arr, 9)) {
            integers.forEach(i -> System.out.print(i + " "));
            System.out.println();
        }
    }
}
