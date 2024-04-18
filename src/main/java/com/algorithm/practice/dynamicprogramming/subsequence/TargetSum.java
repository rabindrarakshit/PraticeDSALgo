package com.algorithm.practice.dynamicprogramming.subsequence;

import java.util.Arrays;

// Ref: https://takeuforward.org/data-structure/target-sum-dp-21/

public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        int targetSum = (sum - target) / 2;

        if (sum - target < 0 || (sum - target) % 2 == 1)
            return 0;

        int length = nums.length;
        int[][] ways = new int[length][targetSum + 1];

        if (nums[0] == 0) {
            ways[0][0] = 2;
        } else {
            ways[0][0] = 1;
        }

        if (nums[0] != 0 && nums[0] <= targetSum) {
            ways[0][nums[0]] = 1;
        }

        for (int index = 1; index < length; index++) {
            for (int tSum = 0; tSum <= targetSum; tSum++) {
                int notTake = ways[index - 1][tSum];
                int take = 0;
                if (nums[index] <= tSum) {
                    take = ways[index - 1][tSum - nums[index]];
                }
                ways[index][tSum] = take + notTake;
            }
        }
        return ways[length - 1][targetSum];
    }




}
