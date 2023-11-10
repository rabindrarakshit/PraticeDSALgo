package com.algorithm.practice.string;

public class Permutation1 {
    public static void main(String[] args) {
        permutation("Rabi", "");
    }

    public static void permutation(String str, String suffix) {
        if (str.length() <= 0) {
            System.out.println(suffix);
        } else {
            permutation(str.substring(0, str.length() - 2), suffix + str.charAt(str.length() - 1));
        }
    }
}
