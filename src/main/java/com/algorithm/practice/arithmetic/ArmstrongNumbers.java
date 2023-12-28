package com.algorithm.practice.arithmetic;

/*
 * Armstrong Numbers are the numbers having the sum of digits raised
 * to power no. of digits is equal to a given number. Examples- 0, 1, 153, 370, 371, 407, and 1634
 * are some Armstrong Numbers.
 *
 *
 * */
public class ArmstrongNumbers {
    static boolean checkArmstrong(int n) {
        int digits = 0;
        int temp = n;
        int sum = 0;
        while (temp != 0) {
            digits++;
            temp = temp / 10;
        }
        temp = n;
        while (temp != 0) {
            int cur = temp % 10;
            sum = sum + (int) Math.pow(cur, digits);
            temp = temp / 10;
        }
        return sum == n;
    }

    public static void main(String[] args) {
        System.out.println(checkArmstrong(153));
        System.out.println(checkArmstrong(154));
    }
}
