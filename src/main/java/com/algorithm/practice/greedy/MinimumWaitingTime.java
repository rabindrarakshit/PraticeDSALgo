package com.algorithm.practice.greedy;

import java.util.Arrays;

// Ref: https://www.algoexpert.io/questions/minimum-waiting-time
// Time: O(nlog(n)) | Space: O(1)

public class MinimumWaitingTime {
    public int minimumWaitingTime(int[] queries){
        int total=0;
        int n = queries.length -1;
        Arrays.sort(queries);
        for(int i=0;i<queries.length;i++){
            total+=queries[i]*(n-i);
        }
        return total;
    }
}
