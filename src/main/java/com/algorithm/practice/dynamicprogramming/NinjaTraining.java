package com.algorithm.practice.dynamicprogramming;

//Ref: https://takeuforward.org/data-structure/dynamic-programming-ninjas-training-dp-7/
// Space : O(2*tasks) | Time: O(days*(tasks+1)*(tasks))
public class NinjaTraining {
    static int maxPoints(int[][] points) {
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

    public static void main(String[] args) {
        int[][] points = {{10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}};

        System.out.println(maxPoints(points));
    }
}
