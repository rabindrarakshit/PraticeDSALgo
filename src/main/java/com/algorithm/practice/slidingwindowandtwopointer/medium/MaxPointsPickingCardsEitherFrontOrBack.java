package com.algorithm.practice.slidingwindowandtwopointer.medium;

// Ref: https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
public class MaxPointsPickingCardsEitherFrontOrBack {

    // Time : O(2^N)
    // Time Limit Exceeded
    static int maxScore(int[] arr, int k, int i, int j, int sum) {
        if (i >= arr.length || k == 0) {
            return sum;
        }
        int sum1 = maxScore(arr, k - 1, i + 1, j, sum + arr[i]);
        int sum2 = maxScore(arr, k - 1, i, j + 1, sum + arr[arr.length - j - 1]);
        return Math.max(sum1, sum2);
    }

    static int maxScore(int[] arr, int k) {
        return maxScore(arr, k, 0, 0, 0);
    }

    // Time: O(2N)
    static int maxScoreSlidingWindow(int[] arr, int k) {
        int sum = 0;
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int lsum = sum, rsum = 0;
        for (int i = 0; i < k; i++) {
            rsum += arr[n - 1 - i];
            lsum -= arr[k - 1 - i];
            sum = Math.max(sum, lsum + rsum);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maxScoreSlidingWindow(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }
}
