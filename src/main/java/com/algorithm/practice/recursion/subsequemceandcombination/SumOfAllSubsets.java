package com.algorithm.practice.recursion.subsequemceandcombination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Ref: https://takeuforward.org/data-structure/subset-sum-sum-of-all-subsets/
// Time: O(2^n)+O(2^n log(2^n))
// Space : O(2^n) ~ But this is also just used for the output

public class SumOfAllSubsets {
    static void sumOfAllSubsets(int[] arr, int sum, List<Integer> result, int index) {
        if (index == arr.length) {
            result.add(sum);
            return;
        }
        sumOfAllSubsets(arr, sum + arr[index], result, index + 1);
        sumOfAllSubsets(arr, sum, result, index + 1);
    }

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[]{5, 2, 1};
        sumOfAllSubsets(arr, 0, result, 0);
        Collections.sort(result);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
