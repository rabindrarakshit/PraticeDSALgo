package com.algorithm.practice.dynamicprogramming.lis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Ref: https://takeuforward.org/data-structure/longest-divisible-subset-dp-44/

public class LongestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        List<Integer> dp = new ArrayList<>(Collections.nCopies(n, 1));
        List<Integer> hash = new ArrayList<>(Collections.nCopies(n, 0));

        Collections.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            hash.set(i, i);
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && (dp.get(j) + 1 > dp.get(i))) {
                    dp.set(i, dp.get(j) + 1);
                    hash.set(i, j);
                }
            }
        }
        int max = -1;
        int max_index = -1;
        for (int i = 0; i < dp.size(); i++) {
            if (dp.get(i) > max) {
                max = dp.get(i);
                max_index = i;
            }
        }
        int index = max_index;
        list.add(nums[index]);
        while(index!=hash.get(index)){
            index = hash.get(index);
            list.add(nums[index]);
        }
        Collections.reverse(list);
        return list;
    }
}
