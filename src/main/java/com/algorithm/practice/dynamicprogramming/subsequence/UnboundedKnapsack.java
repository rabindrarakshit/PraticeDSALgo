package com.algorithm.practice.dynamicprogramming.subsequence;

//Ref: https://takeuforward.org/data-structure/unbounded-knapsack-dp-23/

public class UnboundedKnapsack {
    static int maxAmount(int[] values, int[] weight, int w) {
        int maxAmount[][] = new int[values.length][w + 1];
        for (int wt = 0; wt <= w; wt++) {
            maxAmount[0][wt] = (wt / weight[0]) * values[0];
        }

        for(int index=1;index<values.length;index++){
            for(int wt=0;wt<=w;wt++){
                int notTake = maxAmount[index-1][wt];
                int take =0;
                if(weight[index]<=wt){
                    take = values[index] + maxAmount[index][wt-weight[index]];
                }
                maxAmount[index][wt] = Math.max(take, notTake);
            }
        }
        return maxAmount[values.length-1][w];
    }

    public static void main(String[] args) {
        int wt[] = { 2, 4, 6 };
        int val[] = { 5, 11, 13 };
        int W = 10;

        // Call the unboundedKnapsack function and print the result
        System.out.println("The Maximum value of items the thief can steal is " + maxAmount(val, wt, W));
    }

}
