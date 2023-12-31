package com.algorithm.practice.search.binarysearch;

public class LowerBound {
    public static void main(String[] args) {
        System.out.println(lowerBound(new int[]{1, 2, 3, 4, 6, 7, 8}, 5));
    }

    static int lowerBound(int[] arr, int num) {
        int lowerBound = Integer.MAX_VALUE;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= num && mid < lowerBound) {
                lowerBound = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return lowerBound;
    }
}
