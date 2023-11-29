package com.algorithm.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        int[] buckets = new int[10001];
        for (int num : nums) {
            buckets[num] += num;
        }
        int[] dp = new int[10001];
        dp[0] = buckets[0];
        dp[1] = buckets[1];
        for (int i = 2; i < buckets.length; i++) {
            dp[i] = Math.max(buckets[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[10000];
    }

    public static int rob(int[] nums) {
        int len  = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (i == 1) {
                dp[i] = Math.max(nums[i],dp[i - 1]);
                continue;
            }
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
       // System.out.println(deleteAndEarn(new int[]{1,2,3,3,3,4}));
      //  System.out.println(rob(new int[]{2,1,4,6}));

        Map<Integer,Integer> testMap = new HashMap<>();
        testMap.put(1,2);
        testMap.put(7,6);
        testMap.put(3,4);
        testMap.put(9,8);
        testMap.keySet().stream().forEach(System.out::println);

    }
}
