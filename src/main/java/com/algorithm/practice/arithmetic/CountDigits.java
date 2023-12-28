package com.algorithm.practice.arithmetic;

public class CountDigits {
    static int countDigits(int n) {
        int count = 0;
        while (n >= 1) {
            count++;
            n = n / 10;
        }
        return count;
    }

    static int count_digits(int n) {
        String n2 = Integer.toString(n);
        return n2.length();
    }

    static int count_digits_log(int n) {
        int digits = (int) Math.floor(Math.log10(n) + 1);
        return digits;
    }

    public static void main(String[] args) {
        System.out.println(countDigits(200));
    }
}
