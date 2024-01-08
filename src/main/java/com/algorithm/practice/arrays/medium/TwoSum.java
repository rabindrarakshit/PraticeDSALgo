package com.algorithm.practice.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        for (int i : twoSumTwoLoop(arr, 6)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : twoSumHashMap(arr, 6)) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i : twoSumTwoPointer(arr, 6)) {
            System.out.print(i + " ");
        }

    }

    // Time Complexity: O(N^2)
    // Space Complexity : O(1)

    static int[] twoSumTwoLoop(int[] arr, int k) {
        int[] result = new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == k) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    // Time Complexity: O(N)
    // Space Complexity : O(N)

    static int[] twoSumHashMap(int[] arr, int k) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(k - arr[i])) {
                result[0] = i;
                result[1] = map.get(k - arr[i]);
                break;
            }
            map.put(arr[i], i);
        }
        return result;
    }

    // Time Complexity: O(NlogN + N)
    // Space Complexity : O(1)

    static int[] twoSumTwoPointer(int[] arr, int k) {
        int[] result = new int[2];
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            if (arr[left] + arr[right] == k) {
                result[0] = left;
                result[1] = right;
                break;
            } else if (arr[left] + arr[right] < k) {
                left++;
            } else {
                right++;
            }
        }
        return result;
    }
}
