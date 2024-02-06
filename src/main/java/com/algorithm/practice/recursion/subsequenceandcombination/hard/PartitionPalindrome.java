package com.algorithm.practice.recursion.subsequenceandcombination.hard;

import java.util.ArrayList;
import java.util.List;

// Time Complexity: O( (2^n) *k*(n/2) )
// Space Complexity: O(k * x)
// Ref: https://takeuforward.org/data-structure/palindrome-partitioning/

public class PartitionPalindrome {
    static boolean isPalindrome(String str, int i, int j) {
        while (i <= j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    static void partitionPalindrome(int index, List<String> list, List<List<String>> result, String str) {
        if (index == str.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < str.length(); i++) {
            if (isPalindrome(str, index, i)) {
                list.add(str.substring(index, i + 1));
                partitionPalindrome(i + 1, list, result, str);
                list.remove(list.size() - 1);
            }
        }

    }

    public static void main(String[] args) {
        List<List<String>> result = new ArrayList<>();
        partitionPalindrome(0, new ArrayList<>(), result, "aba");
        for (List<String> list : result) {
            for (String i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
