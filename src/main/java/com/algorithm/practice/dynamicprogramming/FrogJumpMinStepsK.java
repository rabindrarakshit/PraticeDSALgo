package com.algorithm.practice.dynamicprogramming;

public class FrogJumpMinStepsK {
    static int minJumps(int[] height, int k) {
        int dp[] = new int[height.length];
        dp[0] = 0;
        for (int i = 1; i < height.length; i++) {
            int me = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(height[i] - height[i - j]);
                    me = Math.min(me, jump);
                }
            }
            dp[i] = me;
        }
        return dp[height.length-1];
    }

    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{30, 10, 60, 10, 60, 50}, 2));
    }
}
