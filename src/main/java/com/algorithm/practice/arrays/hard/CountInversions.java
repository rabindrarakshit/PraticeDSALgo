package com.algorithm.practice.arrays.hard;

// Problem Statement: Given an array of N integers, count the inversion of the array (using merge-sort).
//
//What is an inversion of an array? Definition: for all i & j < size of array, if i < j then you have to
// find pair (A[i],A[j]) such that A[j] < A[i].

// Ref: https://takeuforward.org/data-structure/count-inversions-in-an-array/

// Time Complexity: O(Nlog(N))
// Space Complexity: O(N)

public class CountInversions {
    static int countInversions(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    static int mergeSort(int[] arr, int low, int high) {
        int finalCount = 0;
        if (low >= high) return finalCount;
        int mid = low + (high - low) / 2;
        finalCount += mergeSort(arr, low, mid);
        finalCount += mergeSort(arr, mid + 1, high);
        finalCount += merge(arr, low, mid, high);
        return finalCount;
    }

    static int merge(int[] arr, int low, int mid, int high) {
        int count = 0;
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= high) {
            if (arr[left] > arr[right]) {
                temp[k] = arr[right];
                count += mid - left + 1;
                right++;
            } else {
                temp[k] = arr[left];
                left++;
            }
            k++;
        }
        while (left <= mid) {
            temp[k] = arr[left];
            k++;
            left++;
        }
        while (right <= high) {
            temp[k] = arr[right];
            k++;
            right++;
        }
        for (int l = 0, id = low; l < temp.length; l++, id++) {
            arr[id] = temp[l];
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countInversions(new int[]{5, 4, 3, 2, 1}));
    }

}
