package com.algorithm.practice.recursion;

public class Exponent {
    public static void main(String[] args) {
        int n = 5;
        int x = 2;
        System.out.println(power(x, n));
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
    public static long power(long x, long y) {
        long temp;
        if (y == 0) return 1;
        temp = power(x, y / 2);
        if (y % 2 == 0) return (temp * temp);
        else return (x * temp * temp);
    }
}
