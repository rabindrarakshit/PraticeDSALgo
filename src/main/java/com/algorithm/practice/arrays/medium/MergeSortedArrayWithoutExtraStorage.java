package com.algorithm.practice.arrays.medium;

public class MergeSortedArrayWithoutExtraStorage {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        for (; i < m + n && j < n; i++) {
            if (i - j == m) {
                while (j < n) {
                    nums1[i] = nums2[j];
                    i++;
                    j++;
                }
                break;
            }
            if (nums1[i] > nums2[j]) {
                for (int k = m + j; k > i && k < m + n; k--) {
                    nums1[k] = nums1[k - 1];
                }
                nums1[i + 1] = nums1[i];
                nums1[i] = nums2[j];
                j++;
            }
        }
    }
}
