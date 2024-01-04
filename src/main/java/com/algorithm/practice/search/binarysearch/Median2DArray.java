package com.algorithm.practice.search.binarysearch;

public class Median2DArray {

    static int countElementsSmallerThanMid(int[] arr, int median) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= median) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    static int findMedian(int[][] arr) {
        int low = 0;
        int high = 10 ^ 9;
        int row = arr.length;
        int col = arr[0].length;
        int medianIndex = ((row * col) / 2);
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int count = 0;
            for (int[] i : arr) {
                count += countElementsSmallerThanMid(i, mid);
            }
            if (count <= medianIndex) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 8},
                {2, 3, 4},
                {1, 2, 5}};
        System.out.println("The median of the row-wise sorted matrix is: " +
                findMedian(arr));
    }
}
