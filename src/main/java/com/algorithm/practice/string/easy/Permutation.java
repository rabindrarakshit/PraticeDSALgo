package com.algorithm.practice.string.easy;

public class Permutation {
    public static void permutation(String str, String prefix) {
        if (str.length() == 0) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                String rem = str.substring(0, i) + str.substring(i + 1);
                permutation(rem, prefix + str.charAt(i));
            }
        }
    }

    public static void permutation1(String str, String suffix) {
        if (str.length() <= 0) {
            System.out.println(suffix);
        } else {
            permutation(str.substring(0, str.length() - 2), suffix + str.charAt(str.length() - 1));
        }
    }

    public static void main(String[] args) {
        permutation("abc", "");
        permutation1("Rabi", "");
    }
}
