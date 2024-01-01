package com.algorithm.practice.search.binarysearch;

public class SearchRotatedSortedArray {
    static int search(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == num) {
                index = mid;
                break;
            }
            if (arr[mid] >= arr[low]) {
                if (num >= arr[low] && num <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (num >= arr[mid] && num <= arr[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{7, 6, 1, 2, 3, 4, 5}, 5));
        System.out.println(search(new int[]{7, 6, 1, 2, 3, 4, 5}, 7));
        System.out.println(search(new int[]{7, 6, 1, 2, 3, 4, 5}, 6));
    }
}
