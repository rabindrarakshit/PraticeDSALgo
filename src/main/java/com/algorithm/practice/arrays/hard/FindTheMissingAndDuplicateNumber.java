package com.algorithm.practice.arrays.hard;


// Problem Statement: You are given a read-only array of N integers with values also in the range [1, N] both inclusive.
// Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the
// repeating and missing numbers A and B where A repeats twice and B is missing.

// ref :https://takeuforward.org/data-structure/find-the-repeating-and-missing-numbers/

// Time Complexity: O(n)
// Space Complexity: O(1)

public class FindTheMissingAndDuplicateNumber {
    static int[] findElements(int[] arr) {
        int n = arr.length;

        int sumN = (n * (n + 1)) / 2;
        int sum2N = (n * (n + 1) * (2 * n + 1)) / 6;

        int currentSum = 0;
        int current2Sum = 0;
        for (int i : arr) {
            currentSum += i;
            current2Sum += i * i;
        }

        int diff = currentSum - sumN;
        int sum = (current2Sum - sum2N) / diff;

        int el1 = (sum + diff) / 2;
        int el2 = sum - el1;
        return new int[]{el1, el2};
    }

    public static void main(String[] args) {
        for (int i : findElements(new int[]{1, 2, 2, 3}))
            System.out.println(i);
    }
}
