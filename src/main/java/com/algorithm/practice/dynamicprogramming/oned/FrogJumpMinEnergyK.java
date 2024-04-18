package com.algorithm.practice.dynamicprogramming.oned;

public class FrogJumpMinEnergyK {
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

    static int minEnergy(int[] heights, int n, int k) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return Math.abs(heights[1] - heights[0]);
        }
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=k && i<=n;i++){
            min = Math.min(min, Math.abs(heights[n] - heights[n - i]) + minEnergy(heights, n - i, k));
        }
       return min;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{30, 10, 60, 10, 60, 50};
        System.out.println(minJumps(heights, 2));
        System.out.println(minEnergy(heights, heights.length-1, 2));
    }
}
