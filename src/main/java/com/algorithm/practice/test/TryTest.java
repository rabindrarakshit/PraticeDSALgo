package com.algorithm.practice.test;

import java.util.ArrayList;
import java.util.List;

public class TryTest {
    public static void main(String[] args) {
        permutation(new ArrayList<>(), "", "abc").forEach(str-> System.out.println(str));
    }

    static List<String> permutation(List<String> list, String permutation, String newString) {
        if (newString.length() == 0) {
            list.add(permutation);
        }
        for (int i = 0; i < newString.length(); i++) {
            char cur = newString.charAt(i);
            String subString = newString.substring(0, i) + newString.substring(i + 1);
            permutation(list, permutation + cur, subString);
        }
        return list;
    }


}
