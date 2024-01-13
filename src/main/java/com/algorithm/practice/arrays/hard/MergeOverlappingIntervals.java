package com.algorithm.practice.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {
    static List<List<Integer>> mergeOverlappingIntervalsOptimized(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (list.isEmpty() || arr[i][0] >= list.get(list.size() - 1).get(1)) {
                list.add(Arrays.asList(arr[i][0], arr[i][1]));
            } else {
                list.get(list.size() - 1).set(1, Math.max(list.get(list.size() - 1).get(1), arr[i][1]));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        for (List<Integer> it : mergeOverlappingIntervalsOptimized(arr)) {
            System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
        }
    }
}
