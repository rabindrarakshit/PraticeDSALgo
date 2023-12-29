package com.algorithm.practice.recursion;

public class BasicRecursion {

    static boolean checkPalindrome(String s, int front, int back) {
        if (front >= back) {
            return true;
        }
        if (s.charAt(front) != s.charAt(back)) {
            return false;
        }
        return checkPalindrome(s, front + 1, back - 1);
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(checkPalindrome(s, 0, s.length() - 1));
    }
}
