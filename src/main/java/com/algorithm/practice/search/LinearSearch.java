package com.algorithm.practice.search;

public class LinearSearch {
    public int search(int[] a, int x) {
        int pos;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x)
                return i;
        }
        return -1;
    }
}
