package com.algorithm.practice.arrays;

public class MissingElementUnsortedArray {
    static int missingElement(int[] arr, int n) {
        int nSum = (n * (n + 1)) / 2;
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return nSum - sum;
    }

    // Logic : 0^n = n, n^n = 0
    static int missingXOR(int[] arr, int n) {
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < arr.length; i++) {
            xor1 = xor1 ^ (i + 1);
            xor2 = xor2 ^ arr[i];
        }
        xor1 = xor1 ^ n;
        return xor1 ^ xor2;
    }

    public static void main(String[] args) {
        System.out.println(missingElement(new int[]{1, 2, 3, 5}, 5));
        System.out.println(missingXOR(new int[]{1, 2, 3, 5}, 5));
    }
}
