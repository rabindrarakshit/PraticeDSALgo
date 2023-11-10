package com.algorithm.practice.search;

import java.util.Arrays;

public class BinarySearch {
    public static int search(int[] a, int x) {
        Arrays.sort(a);
        return search(a, 0, a.length - 1, x);
    }

    private static int search(int[] a, int begin, int end, int item) {
        int mid = (begin + end) / 2;
        int index =-1;
        if (a[mid] == item){
            return mid;
        } else if (a[mid] < item && mid < end) {
            index = search(a, mid + 1, end, item);
        } else if (a[mid] > item && mid > begin) {
            index = search(a, begin, mid, item);
        }
        return index;
    }
}
