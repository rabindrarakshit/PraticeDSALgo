package com.algorithm.practice.dynamicprogramming.oned;

public class FrogJumpMinSteps {
    static int minJumps(int[] heights) {
        int prev0 = 0;
        int prev = 0;
        int current = 0;
        int stairs = heights.length;

        for (int i = 1; i < stairs; i++) {
            int jump2 = Integer.MAX_VALUE;
            int jump1 = prev + Math.abs(heights[i] - heights[i - 1]);
            if (i > 1) {
                jump2 = prev0 + Math.abs(heights[i] - heights[i - 2]);
            }
            current = Math.min(jump2, jump1);
            prev0 = prev;
            prev = current;
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println(minJumps(new int[]{30, 10, 60, 10, 60, 50}));
    }
}
