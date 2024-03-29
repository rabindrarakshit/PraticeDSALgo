package com.algorithm.practice.dynamicprogramming.lis;

import java.util.Arrays;

// Ref: https://takeuforward.org/data-structure/number-of-longest-increasing-subsequences-dp-47/

public class NumberOfLongestSubSequences {
    static int numberOfLongestSubSequence(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ct = new int[arr.length];

        Arrays.fill(dp, 1);
        Arrays.fill(ct, 1);
        int max =1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    if (dp[j] + 1 == dp[i]) {
                        ct[i] = ct[i] + ct[j];
                    }
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        int numberOfLongestSub = 0;
        for(int i=0; i< arr.length; i++){
            if(dp[i]==max) numberOfLongestSub+=ct[i];
        }

        return numberOfLongestSub;
    }
}
