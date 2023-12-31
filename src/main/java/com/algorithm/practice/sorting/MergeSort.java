package com.algorithm.practice.sorting;

// Time Complexity: O(nlog(n))
// Space Complexity: O(n)

public class MergeSort {
    public static void mergeSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int mid = begin + (end - begin) / 2;
            mergeSort(arr, begin, mid);
            mergeSort(arr, mid + 1, end);
            combine(arr, begin, mid, end);
        }
    }

    public static void combine(int[] arr, int begin, int mid, int end) {
        int[] sorted = new int[end - begin + 1];
        int idx1 = begin;
        int idx2 = mid + 1;
        int k = 0;
        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] <= arr[idx2]) {
                sorted[k++] = arr[idx1++];
            } else {
                sorted[k++] = arr[idx2++];
            }
        }
        while (idx1 <= mid) {
            sorted[k++] = arr[idx1++];
        }
        while (idx2 <= end) {
            sorted[k++] = arr[idx2++];
        }
        for (int s = 0, l = begin; s < sorted.length; s++, l++) {
            arr[l] = sorted[s];
        }
    }

    static void printArray(int[] arr) {
        for (int i : arr)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: ");
        printArray(arr);
    }
}
