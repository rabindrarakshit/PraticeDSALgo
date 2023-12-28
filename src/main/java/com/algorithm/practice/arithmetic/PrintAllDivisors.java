package com.algorithm.practice.arithmetic;

public class PrintAllDivisors {

    static void printALlDivisorsBrute(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    static void printAllDivisorsOptimized(int n) {
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                if (i != (n / i)) {
                    System.out.print(n / i + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        printALlDivisorsBrute(36);
        printAllDivisorsOptimized(36);
    }
}
