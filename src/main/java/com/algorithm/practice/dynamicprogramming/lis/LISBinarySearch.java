package com.algorithm.practice.dynamicprogramming.lis;

// Ref: https://takeuforward.org/data-structure/longest-increasing-subsequence-binary-search-dp-43/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LISBinarySearch {
    public int lengthOfLIS(int[] arr) {
        List<Integer> temp = new ArrayList<>();
        int n = arr.length;
        temp.add(arr[0]);
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > temp.get(temp.size() - 1)) {
                temp.add(arr[i]);
                len++;
            } else {
                int ind = Collections.binarySearch(temp, arr[i]);
                if (ind < 0) {
                    ind = -ind - 1;
                }
                temp.set(ind, arr[i]);
            }
        }
        return len;
    }
}
