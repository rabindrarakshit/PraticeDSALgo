package com.algorithm.practice.arrays.medium;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] input = new int[]{2, 1, 0, 2};
        for (int i : sort012(input)) {
            System.out.println(i);
        }
    }

    public static int[] sort012(int[] arr) {
        int low = 0, mid = 0;
        int high = arr.length - 1;

        while (mid < high) {
            if (arr[mid] == 0) {
                // Swap low and mid and increment both
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
                low++;
                mid++;
            }
            if (arr[mid] == 1) {
                // Here we need to understand that when low nad mid are not same low will always
                // point to a 1. Because if something was 0 before mid both low and mid was incremented
                // only when its 1 low is not incremented and mid is incremented
                mid++;
            }
            if (arr[mid] == 2) {
                // Even if we swap with high the high currently can be a 2 already so in that case mid
                // after swapping gets the 2. Hence, we don't increment mid in this case.
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid] = temp;
                high--;
            }
        }
        return arr;
    }
}
