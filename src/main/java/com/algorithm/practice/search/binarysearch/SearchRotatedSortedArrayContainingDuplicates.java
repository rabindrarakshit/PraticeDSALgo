package com.algorithm.practice.search.binarysearch;

public class SearchRotatedSortedArrayContainingDuplicates {
    static int search(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (num == arr[mid]) {
                return mid;
            }
            if (arr[high] == arr[mid] && arr[mid] == arr[low]) {
                low = low + 1;
                high = high - 1;
                continue;
            }
            if (arr[mid] >= arr[low]) {
                if (num >= arr[low] && num <= arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (num <= arr[high] && num >= arr[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{3,1,2,3,3,3,3}, 2));
    }
}
