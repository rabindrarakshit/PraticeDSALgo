package com.algorithm.practice.dynamicprogramming.twod;

import java.util.Arrays;

//Ref: https://takeuforward.org/data-structure/dynamic-programming-ninjas-training-dp-7/
// Space : O(2*tasks) | Time: O(days*(tasks+1)*(tasks))
public class NinjaTraining {
    static int maxPointsTabuOpt(int[][] points) {
        int tasks = points[0].length;
        int days = points.length;
        int[] prev = new int[tasks + 1];

        for (int last = 0; last <= tasks; last++) {
            int max = Integer.MIN_VALUE;
            for (int task = 0; task < tasks; task++) {
                if (task != last) {
                    max = Math.max(max, points[0][task]);
                }
            }
            prev[last] = max;
        }

        for (int day = 1; day < days; day++) {
            int[] cur = new int[tasks + 1];
            for (int last = 0; last <= tasks; last++) {
                int max = Integer.MIN_VALUE;
                for (int task = 0; task < tasks; task++) {
                    if (last != task) {
                        max = Math.max(points[day][task] + prev[task], max);
                    }
                }
                cur[last] = max;
            }
            prev = cur;
        }

        return prev[tasks];
    }

    static int maxPointsRecur(int[][] points, int last, int n) {
        if (n < 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < points[0].length; i++) {
            if (i != last) {
                max = Math.max(max, points[n][i] + maxPointsRecur(points, i, n - 1));
            }
        }
        return max;
    }

    static int maxPointsMemo(int[][] points, int last, int n, int[][] dp) {
        if (n < 0) {
            return 0;
        }
        if (dp[n][last] != -1) {
            return dp[n][last];
        }
        int max = Integer.MIN_VALUE;
        if (n == points.length - 1) {
            for (int i = 0; i < points[0].length; i++) {
                max = Math.max(max, points[n][i] + maxPointsMemo(points, i, n - 1, dp));
            }
        } else {
            for (int i = 0; i < points[0].length; i++) {
                if (i != last) {
                    max = Math.max(max, points[n][i] + maxPointsMemo(points, i, n - 1, dp));
                }
            }
        }
        dp[n][last] = max;
        return max;
    }

    static int maxPointsTabu(int[][] points) {

        int[][] dp = new int[points.length][points[0].length];
        for (int day = 0; day < points.length; day++) {
            if (day == 0) {
                for (int i = 0; i < points[0].length; i++) {
                    int max = Integer.MIN_VALUE;
                    for (int j = 0; j < points[0].length; j++) {
                        if (j != i) {
                            max = Math.max(max, points[day][j]);
                        }
                    }
                    dp[day][i] = max;
                }
            } else {
                for (int i = 0; i < points[0].length; i++) {
                    int max = Integer.MIN_VALUE;
                    for (int j = 0; j < points[0].length; j++) {
                        if (j != i) {
                            max = Math.max(max, points[day][j] + dp[day - 1][j]);
                        }
                    }
                    dp[day][i] = max;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i : dp[points.length - 1]) {
            max = Math.max(max, i);
        }
        return max;
    }


    public static void main(String[] args) {
        int[][] points = {{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};
        System.out.println(maxPointsRecur(points, -1, points.length - 1));
        int[][] dp = new int[points.length][points[0].length];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(maxPointsMemo(points, 0, points.length - 1, dp));
        System.out.println(maxPointsTabu(points));
        System.out.println(maxPointsTabuOpt(points));
    }
}
