package com.algorithm.practice.recursion;

// Ref: https://leetcode.com/problems/count-good-numbers/

public class CountGoodNumbers {

    public static int countGoodNumbers(long n) {
        int mod = (int) 1e9 + 7;
        long first = (n % 2 == 0 ? (n / 2) : (n / 2) + 1);//deciding n/2 or n/2+1 depending on n is even or odd
        long second = n / 2;//second power would be n/2 only irrespective of even or odd
        long mul1 = power(5, first) % mod;//5 power n/2
        long mul2 = power(4, second) % mod;//4 power n/2
        long ans = 1;
        ans = (ans * mul1) % mod;//computing total product
        ans = (second != 0) ? (ans * mul2) % mod : ans;//computing total product
        return (int) (ans % mod);
    }

    public static long power(long x, long y) {
        int mod = (int) 1e9 + 7;
        long temp;
        if (y == 0) return 1;
        temp = power(x, y / 2);
        if (y % 2 == 0) return (temp * temp) % mod;
        else return (x * temp * temp) % mod;
    }


    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1));
        System.out.println(countGoodNumbers(2));
        System.out.println(countGoodNumbers(50));

    }
}
