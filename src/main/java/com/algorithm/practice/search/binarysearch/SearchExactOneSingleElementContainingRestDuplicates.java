package com.algorithm.practice.search.binarysearch;

public class SearchExactOneSingleElementContainingRestDuplicates {
    static int searchSingleElement(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr[0] != arr[1]) {
            return arr[0];
        }
        if (arr[arr.length - 1] != arr[arr.length - 2]) {
            return arr[arr.length - 1];
        }
        int low = 1;
        int high = arr.length - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // If arr[mid] is the single element:
            if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
                return arr[mid];
            }
            if ((mid % 2 == 0 && arr[mid] == arr[mid + 1]) || (mid % 2 == 1 && arr[mid] == arr[mid - 1])) {
                // we are on left and left side does not have the single element
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int ans = searchSingleElement(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6});
        System.out.println("The single element is: " + ans);
    }
}
