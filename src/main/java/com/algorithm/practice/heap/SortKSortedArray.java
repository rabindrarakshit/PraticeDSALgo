package com.algorithm.practice.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// Time: O(N(Log(K))), Space = O(K)
// Ref: https://www.algoexpert.io/questions/sort-k-sorted-array
public class SortKSortedArray {

    // Using extra space
    static List<Integer> sort(List<Integer> array, int k) {
        List<Integer> sorted = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < array.size(); i++) {
            pq.add(array.get(i));
            if (pq.size() == k) {
                sorted.add(pq.poll());
            }
        }
        while (pq.size() != 0) {
            sorted.add(pq.poll());
        }
        return sorted;
    }


    // In Place
    static int[] sortKSortedArray(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < Math.min(k + 1, arr.length); i++) {
            pq.add(arr[i]);
        }
        int indexToBeReplaced = 0;
        for (int i = k + 1; i < arr.length; i++) {
            arr[indexToBeReplaced++] = pq.poll();
            pq.add(arr[i]);
        }
        while (pq.size() > 0) {
            arr[indexToBeReplaced++] = pq.poll();
        }
        return arr;
    }

    public static void main(String[] args) {
       /* for(int i: sort(new ArrayList<>(List.of(3,2,1,5,4,7,6,5)), 3)){
            System.out.print(i+" ");
        }*/
        for (int i : sortKSortedArray(new int[]{3, 2, 1, 5, 4, 7, 6, 5}, 3)) {
            System.out.print(i + " ");
        }
    }
}
