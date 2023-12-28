package com.algorithm.practice.arithmetic;

public class ReverseInteger {
    static int reverseInteger(int n) {
        int reverse = 0;
        while (n != 0) {
            int digit = n % 10;
            reverse = reverse * 10 + digit;
            n = n / 10;
        }
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(32));
    }
}
