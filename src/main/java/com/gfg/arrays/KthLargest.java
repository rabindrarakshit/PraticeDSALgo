package com.gfg.arrays;

public class KthLargest {
    public static int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
      //  k=k-1;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private static int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, hi);
        return i;
    }

    private static void swap(int[] nums, int i, int hi){
        int temp = nums[i];
        nums[i] = nums[hi];
        nums[hi] = temp;
    }

    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{1,2,3,4,5,6,7}, 3));
    }
}
