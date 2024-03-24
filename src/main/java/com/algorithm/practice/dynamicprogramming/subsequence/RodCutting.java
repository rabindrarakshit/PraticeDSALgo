package com.algorithm.practice.dynamicprogramming.subsequence;

//Ref: https://takeuforward.org/data-structure/rod-cutting-problem-dp-24/

public class RodCutting {
    static int maxAmount(int[] price, int l) {
        int size = price.length;
        int maxAmount[][] = new int[size][l + 1];

        for (int length = 0; length <= l; length++) {
            maxAmount[0][length] = length * price[0];
        }

        for (int index = 1; index < size; index++) {
            for (int length = 0; length <= l; length++) {
                int notTake = maxAmount[index - 1][length];
                int take = 0;
                int rodLength = index + 1;
                if (index <= length) {
                    take = price[length] + maxAmount[index][length - rodLength];
                }
                maxAmount[index][length] = Math.max(take, notTake);
            }
        }
        return maxAmount[size - 1][l];
    }

    public static void main(String[] args) {

    }
}
