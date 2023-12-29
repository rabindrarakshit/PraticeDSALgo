package com.algorithm.practice.sorting;

// Time Complexity : O(n^2)
// Space Complexity : O(1)

// Remember swapping a hand of cards

public class SelectionSort {
    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int max = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            int temp = arr[max];
            arr[max] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        sort(arr);
        System.out.println("Sorted array: ");
        printArray(arr);
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
