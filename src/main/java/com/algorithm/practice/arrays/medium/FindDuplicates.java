package com.algorithm.practice.arrays.medium;

// Ref: https://leetcode.com/problems/find-all-duplicates-in-an-array/description/?envType=daily-question&envId=2024-03-25

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicates {
    // My Working Soln
    public List<Integer> findDuplicates(int[] nums) {
        boolean[] hashMap = new boolean[100000];
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (!hashMap[num]) {
                hashMap[num] = true;
            } else {
                set.add(num);
            }
        }
        for (Integer i : set) {
            result.add(i);
        }
        return result;
    }

    // Optimised Soln
    public List<Integer> findDuplicatesOptimized(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(Math.abs(index + 1));
            nums[index] = -nums[index];
        }
        return res;
    }
}
