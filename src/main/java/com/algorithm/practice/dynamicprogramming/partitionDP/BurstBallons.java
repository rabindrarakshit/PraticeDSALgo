package com.algorithm.practice.dynamicprogramming.partitionDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurstBallons {
    static int maxBasicRecur(List<Integer> array, int i, int j) {
        if (i > j) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int operations = array.get(i - 1) * array.get(k) * array.get(j+1) + maxBasicRecur(array, i, k-1) + maxBasicRecur(array, k + 1, j);
            max = Math.max(operations, max);
        }
        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(3, 1, 5, 8));
        array.add(0, 1);
        array.add(1);
        System.out.println(maxBasicRecur(array, 1, array.size()-2));
    }
}
