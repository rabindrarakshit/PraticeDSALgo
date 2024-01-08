package com.algorithm.practice.arrays.easy;

// Right Rotation
// Time Complexity: O(N)
// Space Complexity: O(1)

public class RotateArrayByKPlace {
    static void rotate(int[] arr, int k) {
        reverse(k - 1, arr.length - 1, arr);
        reverse(0, k - 2, arr);
        reverse(0, arr.length - 1, arr);
    }

    static void reverse(int low, int high, int[] arr) {
        int temp;
        while (low < high) {
            temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        rotate(arr, 3);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
