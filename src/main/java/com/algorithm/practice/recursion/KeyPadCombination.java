package com.algorithm.practice.recursion;

public class KeyPadCombination {
    public static String[] keys = new String[]{".", "abc", "def", "ghi", "jkl"};

    public static void main(String[] args) {
        combinations(0, "", "12");
    }
    public static void combinations(int index, String combinations, String input) {
        if (index == input.length()) {
            System.out.println(combinations);
            return;
        }
        String keyCombination = keys[input.charAt(index) - '0'];
        for (char letter : keyCombination.toCharArray()) {
            combinations(index + 1, combinations + letter, input);
        }
    }
}
