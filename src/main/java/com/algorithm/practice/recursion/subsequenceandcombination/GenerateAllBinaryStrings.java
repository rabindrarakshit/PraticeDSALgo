package com.algorithm.practice.recursion.subsequenceandcombination;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinaryStrings {
    static List<String> generateAllBinaryStrings(int n, String s, List<String> list) {
        if (n <= 0) {
            list.add(s);
            return list;
        }
        generateAllBinaryStrings(n - 1, s + "0", list);
        generateAllBinaryStrings(n - 1, s + "1", list);
        return list;
    }

    public static void main(String[] args) {
        generateAllBinaryStrings(3,new String(), new ArrayList<>()).forEach(a -> System.out.print(a + " "));
    }
}
