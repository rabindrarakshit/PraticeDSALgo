package com.algorithm.practice.arrays.hard;

// Time Complexity: O(2nlog(n))
// Space Complexity: O(n)

public class CountReversePairs {
    static int countReversePairs(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

    static int mergeSort(int[] arr, int low, int high) {
        int finalCount = 0;
        if (low >= high) return finalCount;
        int mid = low + (high - low) / 2;
        finalCount += mergeSort(arr, low, mid);
        finalCount += mergeSort(arr, mid + 1, high);
        finalCount += countPairs(arr, low, mid, high);
        merge(arr, low, mid, high);
        return finalCount;
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= high) {
            if (arr[left] > arr[right]) {
                temp[k] = arr[right];
                // This below block was my initial intuition but after dry run I realised the issue with this.
                // When we do the merging of 12413 with low=0, mid =2, high =4, we already move the right pointer
                // past 1 before we reach 4 on the left hand. So we miss this count.
                /*if (arr[left] > 2 * arr[right]) {
                    count += mid - left + 1;
                }*/
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
    }

    static int countPairs(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int count = 0;
        while (left <= mid && right <= high) {
            if (arr[left] > 2 * arr[right]) {
                count += mid - left + 1;
                right++;
            } else {
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countReversePairs(new int[]{4, 1, 2, 3, 1}));
    }

}
