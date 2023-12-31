package com.algorithm.practice.search.binarysearch;

// Time Complexity : O(log(n))

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7}, 7));
        System.out.println(binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7}, 1));

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(bsRecursive(arr, 0, arr.length - 1, 7));
        System.out.println(bsRecursive(arr, 0, arr.length - 1, 1));
    }

    static int binarySearch(int[] arr, int num) {
        int low = 0;
        int high = arr.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == num) {
                index = mid;
                break;
            } else if (arr[mid] < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }

    static int bsRecursive(int[] arr, int low, int high, int num) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == num) {
            return mid;
        } else if (arr[mid] < num) {
            return bsRecursive(arr, mid + 1, high, num);
        } else {
            return bsRecursive(arr, low, mid - 1, num);
        }
    }
}
