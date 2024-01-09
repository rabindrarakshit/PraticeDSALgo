package com.algorithm.practice.arrays.medium;

import java.util.ArrayList;
import java.util.List;

// This algorithm solves for both when there are equal number of positive and negative numbers and
// if there are unequal number of positive and negative numbers

public class RearrangeAlternativePositiveNegativeWithoutChangingOrderOfPositiveAndNegative {
    static void rearrange(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i : arr) {
            if (i < 0) {
                neg.add(i);
            } else {
                pos.add(i);
            }
        }

        if (pos.size() < neg.size()) {
            for (int i = 0; i <= pos.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[(2 * i) + 1] = neg.get(i);
            }
            int index = 2 * pos.size();
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[index] = neg.get(1);
                index++;
            }
        } else {
            for (int i = 0; i < neg.size(); i++) {
                arr[2 * i] = pos.get(i);
                arr[(2 * i) + 1] = neg.get(i);
            }
            int index = 2 * neg.size();
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[index] = pos.get(i);
                index++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, -1, -2, -3, 7, 8};
        rearrange(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
