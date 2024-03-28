package com.algorithm.practice.dynamicprogramming.lis;

import java.util.Arrays;

public class PrintLIS {
    static void printLIS(int[] prices) {
        int[] indexes = new int[prices.length];
        int[] sequences = new int[prices.length];
        Arrays.fill(indexes, 1);
        for (int i = 0; i < prices.length; i++) {
            sequences[i] = i;
            for (int j = 0; j < i; j++) {
                if (prices[j] < prices[i] && ((indexes[j] + 1) > indexes[i])) {
                    indexes[i] = indexes[j] + 1;
                    sequences[i] = j;
                }
            }
        }
        int maxIndex = -1;
        int max = -1;
        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i] > max) {
                max = indexes[i];
                maxIndex = i;
            }
        }

        int index = maxIndex;
        int[] arr = new int[max];
        int ind = max - 1;
        while (sequences[index] != index) {
            arr[ind--] = prices[index];
            index = sequences[index];
        }
        arr[ind] = prices[index];
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        printLIS(new int[]{8, 3, 4, 1, 7});
    }
}
