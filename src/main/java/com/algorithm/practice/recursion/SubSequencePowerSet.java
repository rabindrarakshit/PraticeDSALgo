package com.algorithm.practice.recursion;

import java.util.ArrayList;
import java.util.List;

// ref: https://takeuforward.org/data-structure/power-set-print-all-the-possible-subsequences-of-the-string/
// Time: O(2^n)
// Space: O(n) : recursion stack space

public class SubSequencePowerSet {
    public static void main(String[] args) {
        for (String str : subSequence("abc", 0, "", new ArrayList<>())) {
            System.out.print(str + " ");
        }
    }

    public static List<String> subSequence(String str, int index, String newString, List<String> list) {
        if (index == str.length()) {
            list.add(newString);
            return list;
        }
        subSequence(str, index + 1, newString + str.charAt(index), list);
        subSequence(str, index + 1, newString, list);
        return list;
    }
}
