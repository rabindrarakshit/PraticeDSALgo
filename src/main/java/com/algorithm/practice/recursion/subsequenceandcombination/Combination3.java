package com.algorithm.practice.recursion.subsequenceandcombination;

import java.util.ArrayList;
import java.util.List;

// Ref: https://leetcode.com/problems/combination-sum-iii/

public class Combination3 {
    static void getCombinations(List<List<Integer>> result, List<Integer> list, int k, int index, int target) {
        if (index > 9 || list.size() == k) {
            if (list.size() == k && target == 0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(index);
        getCombinations(result, list, k, index + 1, target - index);
        list.remove(list.size() - 1);
        getCombinations(result, list, k, index + 1, target);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        getCombinations(result, new ArrayList<>(), k, 1, n);
        return result;
    }

    public static void main(String[] args) {

        List<List<Integer>> result = combinationSum3(9, 45);
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }
}
