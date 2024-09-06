package com.algorithm.practice.arithmetic;

public class HCF {
    public static int recursive(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return recursive(n2, n1 % n2);
    }

    public static int iterative(int n1, int n2) {
        if (n1 == 0) {
            return n2;
        }
        while (n2 != 0) {
            if (n1 > n2) {
                n1 = n1 - n2;
            } else {
                n2 = n2 - n1;
            }
        }
        return n1;
    }

    public static int euclidean(int n1, int n2) {
        while (n1 > 0 && n2 > 0) {
            if (n1 > n2) {
                n1 = n1 % n2;
            } else {
                n2 = n2 % n1;
            }
        }
        if (n1 == 0) {
            return n2;
        } else {
            return n1;
        }
    }

    public static void main(String[] args) {
        System.out.println(euclidean(15, 10));
    }
}
