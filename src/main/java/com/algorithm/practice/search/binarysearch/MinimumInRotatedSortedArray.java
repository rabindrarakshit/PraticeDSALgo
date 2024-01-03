package com.algorithm.practice.search.binarysearch;

// Time Complexity : O(log(n))
// Space Complexity: O(1)

public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(min(new int[]{8, 1, 2, 3, 4, 5, 6}));
    }

    static int min(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int min = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[low] <= arr[high]) {
                min = Math.min(min, arr[low]);
                break;
            }

            if (arr[low] <= arr[mid]) {
                min = Math.min(min, arr[low]);
                low = mid + 1;
            } else {
                min = Math.min(min, arr[mid]);
                high = mid - 1;
            }
        }
        return min;
    }
}
