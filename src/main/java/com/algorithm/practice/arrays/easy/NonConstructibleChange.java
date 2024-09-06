package com.algorithm.practice.arrays.easy;

/*
* Source : AlgoExpert
* Problem: First Number missing
* */

import java.util.Arrays;

public class NonConstructibleChange {
    static int firstMissingNumber(int[] coins){
        Arrays.sort(coins);
        int sum=0;
        for(int coin: coins){
            if(coin>sum+1){
                return sum+1;
            }
            sum = sum+coin;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingNumber(new int[]{1,2,5}));
    }
}
