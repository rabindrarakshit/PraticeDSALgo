package com.algorithm.practice.arrays.medium;

//ref: https://takeuforward.org/data-structure/trapping-rainwater/

public class TrappingRainwater {
    // BruteForce
    // Time : O(n^2)
    // Space: O(1)
    static int findVolume1(int[] heights) {
        int volume = 0;
        for (int i = 1; i < heights.length - 1; i++) {
            int index = i;
            int leftMax = 0;
            int rightMax = 0;
            while (index >= 0) {
                leftMax = Math.max(leftMax, heights[index]);
                index--;
            }
            index = i;
            while (index < heights.length) {
                rightMax = Math.max(rightMax, heights[index]);
                index++;
            }
            volume += Math.min(leftMax, rightMax) - heights[i];
        }
        return volume;
    }

    // Prefix/Suffix Array
    // Time : O(3n)
    // Space : O(2n)
    static int findVolume2(int[] heights) {
        int volume = 0;
        int n = heights.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = heights[0];
        suffix[n - 1] = heights[n - 1];

        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], heights[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], heights[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            volume += (Math.min(prefix[i], suffix[i]) - heights[i]);
        }
        return volume;
    }

    // Two Pointer
    // Space : O(1)
    // Time: O(n)
    static int findVolume3(int[] heights) {
        int volume = 0;
        int n = heights.length;
        int left = 0;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (left <= right) {
            if (heights[left] <= heights[right]) {
                leftMax = Math.max(leftMax, heights[left]);
                volume += leftMax - heights[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, heights[right]);
                volume += rightMax - heights[right];
                right--;
            }
        }
        return volume;
    }

    public static void main(String[] args) {
        System.out.println(findVolume1(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(findVolume2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(findVolume3(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
