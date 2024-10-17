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

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] currentInterval = intervals[0];
        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(currentInterval);
        for(int i=1;i<intervals.length;i++){
            int currentEnd = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if(currentEnd>=nextStart){
                currentInterval[1]=Math.max(currentEnd, nextEnd);
            }else{
                currentInterval = intervals[i];
                mergedIntervals.add(currentInterval);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        mergeOverlappingIntervals(arr);
    }
}
