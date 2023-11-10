package com.algorithm.practice.recursion;

public class Permutation {
    public static void main(String[] args) {
        printPerm("abc", "");
    }

    public static void printPerm(String str, String permutation) {
        if (str.length() == 0) {
            System.out.println(permutation);
        }
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String newStr = str.substring(0, i) + str.substring(i + 1);
            printPerm(newStr, permutation + currChar);
        }
    }
}
