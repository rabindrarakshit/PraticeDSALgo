package com.algorithm.practice.recursion.subsequenceandcombination;

import java.util.ArrayList;
import java.util.List;

// Ref: https://takeuforward.org/data-structure/combination-sum-1/
// Time: O(2^t*k)
// Explanation : if we can choose an element once then we have 2 options for every element so it becomes 2^n, but here
// we go on till the target is reached or not reached suppose 5 interations of 2 if the target is 10. So t we have considered that
// iterations. And K is the average number for the new list creation.

// Space: O(k*x), k is the average length and x is the no. of combinations


public class CombinationSum1 {
    public static List<List<Integer>> countCombinations(int[] arr, int givenSum, int sum, int index, List<Integer> sub, List<List<Integer>> result) {
        if (sum == givenSum) {
            result.add(new ArrayList<>(sub));
            return result;
        }
        if (index >= arr.length) {
            return result;
        }
        for (int i = 0; i < arr.length; i++) {
            sub.add(arr[i]);
            countCombinations(arr, givenSum, sum + arr[i], index + 1, sub, result);
            sub.remove(sub.size() - 1);
        }
        return result;
    }

    public static void countCombinationsPickNotPick(int[] arr, int target, List<Integer> sub, List<List<Integer>> result, int index) {
        if (index >= arr.length) {
            if (target == 0) {
                result.add(new ArrayList<>(sub));
            }
            return;
        }
        if (arr[index] <= target) {
            sub.add(arr[index]);
            countCombinationsPickNotPick(arr, target - arr[index], sub, result, index);
            sub.remove(sub.size() - 1);
        }
        countCombinationsPickNotPick(arr, target, sub, result, index + 1);
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        //countCombinationsPickNotPick(new int[]{1, 2}, 2, new ArrayList<>(), result, 0);
        countCombinations(new int[]{1, 2}, 2, 0,0, new ArrayList<>(), result);
        System.out.println();
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.print(" ");
        }

    }
}
