package com.algorithm.practice.recursion.subsequemceandcombination;

import java.util.ArrayList;
import java.util.List;

// ref: https://takeuforward.org/data-structure/power-set-print-all-the-possible-subsequences-of-the-string/


public class SubSequencePowerSet {
    public static void main(String[] args) {
        for (String str : subSequence("123", 0, "", new ArrayList<>())) {
            System.out.print(str + " ");
        }
        System.out.println();
        List<List<Integer>> result = new ArrayList<>();
        subSequenceForLoop(new int[]{1, 2, 3}, result, new ArrayList<>(), 0);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }

    // Time: O(2^n)
    // Space: O(n) : recursion stack space
    public static List<String> subSequence(String str, int index, String newString, List<String> list) {
        if (index == str.length()) {
            list.add(newString);
            return list;
        }
        subSequence(str, index + 1, newString + str.charAt(index), list);
        subSequence(str, index + 1, newString, list);
        return list;
    }

    // Time: O(2^n*k) here k is for copying the new lists.
    // Space: O(n) : recursion stack space
    static void subSequenceForLoop(int[] arr, List<List<Integer>> result, List<Integer> subs, int index) {
        result.add(new ArrayList<>(subs));
        for (int i = index; i < arr.length; i++) {
            subs.add(arr[i]);
            subSequenceForLoop(arr, result, subs, i + 1);
            subs.remove(subs.size() - 1);
        }
    }
}
