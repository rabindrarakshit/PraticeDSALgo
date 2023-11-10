package com.leetcode;

// 1342
public class NumberOfStepsToReduceANumberToZero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(9));
    }

    public static int numberOfSteps(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 0) {
                n = n >> 1;
            } else {
                n--;
            }
            System.out.println(n);
            count++;
        }
        return count;
    }
}
