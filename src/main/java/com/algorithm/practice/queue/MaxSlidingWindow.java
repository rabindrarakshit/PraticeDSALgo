package com.algorithm.practice.queue;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
    // Time : O(n^2)
    // Space : O(1)
    static int[] maxWindow(int[] arr, int k) {
        int[] res = new int[arr.length - k + 1];
        for (int i = 0; i < arr.length - k + 1; i++) {
            int max = arr[i];
            for (int j = i; j < i + 3; j++) {
                max = Math.max(max, arr[j]);
            }
            res[i] = max;
        }
        return res;
    }

    // Time : O(2N)
    // Space: O(K)
    // Leetcode Time: 35ms
    static int[] maxSlidingWindow(int[] arr, int k){
        int[] res= new int[arr.length-k+1];
        int ri=0;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<arr.length;i++){
            if(!deque.isEmpty() && deque.peekFirst()==(i-k)){
                deque.pop();
            }
            while(!deque.isEmpty() && arr[i]>arr[deque.peekLast()]){
                deque.removeLast();
            }
            deque.offer(i);
            if(i>=k-1){
                res[ri++] = arr[deque.peekFirst()];
            }
        }
        return res;
    }

    // Leetcode Time: 4ms
    // Need to be revisited

    int[] maxSlidingWindowTwoPointers(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int id = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                id = i;
            }
        }
        ans[0] = max;
        for (int left = 1, right; left < ans.length; left++) {
            right = left + k - 1;
            if (left <= id) {
                if (max <= nums[right]) {
                    max = nums[right];
                    id = right;
                }
            } else {
                if (nums[right] >= max - 1) {
                    max = nums[right];
                    id = right;
                } else if (nums[left] >= max - 1) {
                    max = nums[left];
                    id = left;
                }
                else {
                    max = Integer.MIN_VALUE;
                    for (int x = left; x < right + 1; x++) {
                        if (nums[x] >= max) {
                            max = nums[x];
                            id = x;
                        }
                    }
                }
            }
            ans[left] = max;
        }

        return ans;
    }

    int[] maxSlidingWindowMaxHeap(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0, j = 0; i < nums.length; i++) {
            maxQueue.add(nums[i]);
            if (maxQueue.size() == k) {
                ans[j++] = maxQueue.peek();
                maxQueue.remove(nums[i - k + 1]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        for (int i : maxSlidingWindow(new int[]{4, 0, -1, 3, 5, 3, 6, 8}, 3)) {
            System.out.print(i + " ");
        }
    }
}
