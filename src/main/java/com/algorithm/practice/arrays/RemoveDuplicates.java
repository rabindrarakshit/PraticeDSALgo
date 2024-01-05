package com.algorithm.practice.arrays;

public class RemoveDuplicates {
    static int removeDuplicates(int[] arr) {
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[j] != arr[i]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 3, 4};
        int index = removeDuplicates(arr);
        for (int i = 0; i < index; i++) {
            System.out.println(arr[i]);
        }
    }
}
