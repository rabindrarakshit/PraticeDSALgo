package com.algorithm.practice.recursion.subsequemceandcombination;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Ref: https://www.youtube.com/watch?v=eQCS_v3bw0Q
// Time: O(2^n)
// Space: O(1)

// Variations:
// 1. Print All Substrings with given sum
// 2. Print one SubString with Given Sum
// 3. Print All SubStrings
// 4. Count All Substrings with given sum

public class PrintAllSubStringWithGivenSum {
    public static List<String> subStringSum(String str, List<String> list, int sum, int index, int givenSum,
                                            String newString) {
        if (index >= str.length()) {
            if (sum == givenSum) {
                list.add(newString);
            }
            return list;
        }
        int digit = Integer.parseInt(String.valueOf(str.charAt(index)));
        subStringSum(str, list, sum + digit, index + 1, givenSum, newString + str.charAt(index));
        subStringSum(str, list, sum, index + 1, givenSum, newString);
        return list;
    }

    public static List<Stack<Integer>> subStringSum(int[] arr, List<Stack<Integer>> list, int sum, int index, int givenSum,
                                                   Stack<Integer> newList) {
        if (index >= arr.length) {
            if (sum == givenSum) {
                Stack<Integer> cloneStack = (Stack<Integer>) newList.clone();
                list.add(cloneStack);
            }
            return list;
        }
        newList.add(arr[index]);
        subStringSum(arr, list, sum + arr[index], index + 1, givenSum, newList);
        newList.pop();
        subStringSum(arr, list, sum, index + 1, givenSum, newList);
        return list;
    }

    public static void main(String[] args) {
        for (String str : subStringSum("121", new ArrayList<>(), 0, 0, 2, "")) {
            System.out.print(str + " ");
        }
        System.out.println();
        for (Stack<Integer> list : subStringSum(new int[]{1, 2, 1}, new ArrayList<>(), 0, 0, 2, new Stack<>())) {
           while(!list.isEmpty()){
               System.out.print(list.pop());
           }
            System.out.print(" ");
        }
        System.out.println();
    }
}
