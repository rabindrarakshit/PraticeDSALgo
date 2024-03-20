package com.algorithm.practice.dynamicprogramming.subsequence;

import java.util.Arrays;

//Ref: https://www.algoexpert.io/questions/min-number-of-coins-for-change
//Time: O(nd) | Space: O(n)

public class MinNumberOfCoinsForChange {
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] numOfCoins = new int[n+1];
        Arrays.fill(numOfCoins, Integer.MAX_VALUE);
        numOfCoins[0]=0;
        int toCompare = 0;
        for(int denom: denoms){
            for(int amount=1;amount<numOfCoins.length;amount++){
                if(denom<=amount){
                    if(numOfCoins[amount-denom]==Integer.MAX_VALUE){
                        toCompare = numOfCoins[amount-denom];
                    }else{
                        toCompare = numOfCoins[amount-denom]+1;
                    }
                    numOfCoins[amount] = Math.min(numOfCoins[amount], toCompare);
                }
            }
        }
        return numOfCoins[n] == Integer.MAX_VALUE? -1: numOfCoins[n];
    }
    public static void main(String[] args) {
        System.out.println(minNumberOfCoinsForChange(9, new int[]{3,5}));
    }
}
