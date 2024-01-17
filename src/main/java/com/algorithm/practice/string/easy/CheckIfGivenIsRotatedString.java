package com.algorithm.practice.string.easy;

public class CheckIfGivenIsRotatedString {
    static boolean check(String str1, String rotatedString){
        // validate for lengths and nulls
        return (str1.length()==rotatedString.length()) && ((rotatedString+rotatedString).contains(str1));
    }

    public static void main(String[] args) {
        System.out.println(check("abcde", "cdeab"));
        System.out.println(check("abcde","cdeba"));
    }
}
