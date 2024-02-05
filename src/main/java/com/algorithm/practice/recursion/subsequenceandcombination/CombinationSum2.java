package com.algorithm.practice.recursion.subsequenceandcombination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// Ref: https://takeuforward.org/data-structure/combination-sum-ii-find-all-unique-combinations/
public class CombinationSum2 {

    // This approach uses Set instead of list where insertion is not constant but log(n), so the time complexity increases to
    // O(2^t*k*log(setSize)), and suppose if the problem states it needs the return type as list then you need to again
    // convert it back to list.
    // The way to avoid the duplicates is skip the next duplicate entry points, which is easy in a for loop but not in recursion.
    public static void countCombinationsPickNotPick(int[] arr, int target, List<Integer> sub, Set<List<Integer>> result, int index) {
        if (index >= arr.length) {
            if (target == 0) {
                List<Integer> temp = new ArrayList<>(sub);
                result.add(temp);
            }
            return;
        }
        if (arr[index] <= target) {
            sub.add(arr[index]);
            countCombinationsPickNotPick(arr, target - arr[index], sub, result, index + 1);
            sub.remove(sub.size() - 1);
        }
        countCombinationsPickNotPick(arr, target, sub, result, index + 1);
    }

    // Time : O(2^n*k)
    // Space: O(k*x)

    public static void countCombinations2(int[] arr, int target, List<Integer> sub, List<List<Integer>> result, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(sub));
            return;
        }
        for (int i = index; i < arr.length; i++) {
            if (i > index && arr[i] == arr[i - 1]) continue;
            if (arr[i] > target) break;
            sub.add(arr[i]);
            countCombinations2(arr, target - arr[i], sub, result, i + 1);
            sub.remove(sub.size() - 1);
        }
    }

    public static void main(String[] args) {
        Set<List<Integer>> result = new HashSet<>();
        List<List<Integer>> resultList = new ArrayList<>();
        int[] arr = new int[]{1, 1, 1, 2};
        Arrays.sort(arr);
        //countCombinationsPickNotPick(arr, 8, new ArrayList<>(), result, 0);
        countCombinations2(arr, 2, new ArrayList<>(), resultList, 0);
        for (List<Integer> list : resultList) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.print(" ");
        }

    }
}
