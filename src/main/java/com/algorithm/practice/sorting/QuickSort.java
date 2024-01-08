package com.algorithm.practice.sorting;

// Time Complexity: Worst Case: O(n^2) Average Case: O(n(log(n)))
// Space Complexity: O(1)

class QuickSort {
    public static void main(String[] args) {
        int[] input = new int[]{5,4, 3, 2, 1};
        quickSort(input);
        for (int i : input) {
            System.out.println(i);
        }
    }

    static void quickSort(int[] arr) {
        qSort(arr, 0, arr.length - 1);
    }

    static void qSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partitionIndex(arr, low, high);
            qSort(arr, low, pIndex - 1);
            qSort(arr, pIndex + 1, high);
        }
    }

    static int partitionIndex(int[] arr, int low, int high) {
        // Here variable pivot is redundant we can just use the low. But it makes the code readable,
        // hence keeping it

        int pivot = low;
        int i = low;
        int j = high;
        while (i < j) {
            while (i <= high - 1 && arr[i] <= arr[pivot]) {
                i++;
            }
            while (j >= low + 1 && arr[j] > arr[pivot]) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = temp;
        return j;
    }
}