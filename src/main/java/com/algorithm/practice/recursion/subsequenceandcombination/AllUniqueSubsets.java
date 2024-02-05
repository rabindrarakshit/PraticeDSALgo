package com.algorithm.practice.recursion.subsequenceandcombination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllUniqueSubsets {

    // This below code with the if is wrong. It's kept on purpose. This below one prints 123 13 23 3 for input 123. We expect also 1
    // and 2 to be printed. The reason you don't have that printed is because we don't have a base case like sum of subsequences
    // so, we always go till the end before stopping. Here the base case is array length.
    static void printUniqueSubsets(int[] arr, List<List<Integer>> result, List<Integer> subs, int index) {
        //     if (index >= arr.length) {
        result.add(new ArrayList<>(subs));
        //          return;
        //      }
        for (int i = index; i < arr.length; i++) {
            subs.add(arr[i]);
            printUniqueSubsets(arr, result, subs, i + 1);
            subs.remove(subs.size() - 1);
        }
    }

    public static void findUniqueSubsetsWithDuplicateElementsInInput(int ind, int[] nums, List<Integer> ds, List<List<Integer>> ansList) {
        ansList.add(new ArrayList<>(ds));
        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1]) continue;
            ds.add(nums[i]);
            findUniqueSubsetsWithDuplicateElementsInInput(i + 1, nums, ds, ansList);
            ds.remove(ds.size() - 1);
        }

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ansList = new ArrayList<>();
        findUniqueSubsetsWithDuplicateElementsInInput(0, nums, new ArrayList<>(), ansList);
        return ansList;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = new ArrayList<>();
        // findSubsets(0, new int[]{1, 2, 3} , new ArrayList<>(),result);
        result = subsetsWithDup(new int[]{1, 1, 2, 3});
        for (List<Integer> list : result) {
            for (Integer i : list) {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }

}
