package com.algorithm.practice.arrays.medium;

public class OneAway {
    public static boolean checkForOneAway(String str1, String str2) {
        String bigger = str1.length() > str2.length() ? str1 : str2;
        String lesser = str1.length() > str2.length() ? str2 : str1;

        for (int big = 0, small = 0; big < bigger.length() && small < lesser.length(); ) {
            if (bigger.charAt(big) != lesser.charAt(small)) {
                if (big != small) {
                    return false;
                }
            } else {
                small++;
            }
            big++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkForOneAway("abc", "abc"));
        System.out.println(checkForOneAway("abc", "abd"));
        System.out.println(checkForOneAway("abc", "add"));
        System.out.println(checkForOneAway("abc", "abde"));
    }


}
