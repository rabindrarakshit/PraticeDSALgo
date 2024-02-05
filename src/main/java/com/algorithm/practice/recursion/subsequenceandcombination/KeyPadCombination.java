package com.algorithm.practice.recursion.subsequenceandcombination;

//Ref: https://leetcode.com/problems/letter-combinations-of-a-phone-number/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KeyPadCombination {
    private static Map<Character, String> letters = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");

    static void combinations(String str, List<Character> list, List<List<Character>> result, int index) {
        if (index == str.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        String charChoices = letters.get(str.charAt(index));
        for (int i = 0; i < charChoices.length(); i++) {
            list.add(charChoices.charAt(i));
            combinations(str, list, result, index+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Character>> result = new ArrayList<>();
        combinations("23", new ArrayList<>(), result, 0);
        for (List<Character> list : result) {
            for (Character i : list) {
                System.out.print(i);
            }
            System.out.print(" ");
        }
    }
}
