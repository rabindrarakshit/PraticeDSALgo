package com.algorithm.practice.dynamicprogramming.subsequence;

import java.util.Arrays;

//Ref: https://www.algoexpert.io/questions/min-number-of-coins-for-change
//Time: O(nd) | Space: O(n)

public class MinNumberOfCoinsForChange {
    // Algo Expert Soln
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

    // Striver Soln
    static int minCoins(int[] denoms, int target){
        int size = denoms.length;
        int dp[][] = new int[size][target+1];

        for(int amount=0;amount<=target;amount++){
            if(amount%denoms[0]==0){
                dp[0][amount]=amount/denoms[0];
            }else{
                dp[0][amount] = (int) Math.pow(10,9);
            }
        }

        for(int index=1;index<size;index++){
            for(int amount=1;amount<=target;amount++){
                int notTake = dp[index-1][amount];
                int take = (int) Math.pow(10, 9);
                if(denoms[index]<=amount){
                    take = 1+dp[index][amount-denoms[index]];
                }
                dp[index][amount] = Math.min(take, notTake);
            }
        }
        if (dp[size-1][target] >= (int) Math.pow(10, 9))
            return -1;
        return dp[size-1][target];
     }
    public static void main(String[] args) {
       // System.out.println(minNumberOfCoinsForChange(9, new int[]{3,5}));
        System.out.println(minCoins( new int[]{1,5}, 10));
    }
}
