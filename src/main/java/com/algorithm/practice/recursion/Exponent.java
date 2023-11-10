package com.algorithm.practice.recursion;

public class Exponent {
    public static void main(String[] args) {
        int n = 5;
        int x = 2;
        System.out.println(calculateExponentLogNStack(x, n));
    }

    // Complexity : O(n)
    public static int printExponent(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        return x * printExponent(x, n - 1);
    }

    // Complexity : O(log(n))
    public static int calculateExponentLogNStack(int x, int n) {
        if (n == 0) {
            return 1;
        }
        if (x == 0) {
            return 0;
        }
        if (n % 2 == 0) {
            return calculateExponentLogNStack(x, n / 2) * calculateExponentLogNStack(x, n / 2);
        } else {
            return calculateExponentLogNStack(x, n / 2) * calculateExponentLogNStack(x, n / 2) * x;
        }
    }
}
