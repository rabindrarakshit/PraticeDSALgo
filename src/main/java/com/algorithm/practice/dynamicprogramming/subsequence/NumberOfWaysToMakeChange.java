package com.algorithm.practice.dynamicprogramming.subsequence;

// Ref: https://www.algoexpert.io/questions/number-of-ways-to-make-change
// Time: O(mn) | Space: O(n)

public class NumberOfWaysToMakeChange {
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n+1];
        ways[0]=1;
        for(int i=0;i<denoms.length;i++){
            for(int j=1;j<=n;j++){
                if(j-denoms[i]>=0){
                    ways[j]+= ways[j-denoms[i]];
                }
            }
        }
        return ways[n];
    }
}
