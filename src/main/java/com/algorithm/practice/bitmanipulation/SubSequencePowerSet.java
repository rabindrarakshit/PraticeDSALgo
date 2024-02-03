package com.algorithm.practice.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

// ref: https://takeuforward.org/data-structure/power-set-print-all-the-possible-subsequences-of-the-string/
// Time: O(2^n * n)
// Space: O(1)

public class SubSequencePowerSet {
    public static void main(String[] args) {
        for (String str : subSequenceBitManipulation("abc")) {
            System.out.print(str + " ");
        }
    }

    public static List<String> subSequenceBitManipulation(String str) {
        List<String> result = new ArrayList<>();
        int n = str.length();
        for (int i = 1; i <= ((1 << n) - 1); i++) {
            String subs = "";
            for (int j = 0; j < n; j++) {
                if ((i & 1 << j) != 0) {
                    subs = subs + str.charAt(j);
                }
            }
            result.add(subs);
        }
        return result;
    }
}
