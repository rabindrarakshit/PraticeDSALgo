package com.algorithm.practice.arrays.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSubArrayOfTargetSum {
    public static int[] longestSubarrayWithSum(int[] array, int targetSum) {
        Map<Integer,Integer> prefixSum = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        int[] res = new int[]{};
        for(int i=0;i<array.length;i++){
            sum+=array[i];
            int length =0;
            int left = 0;
            if(sum==targetSum){
                length = i+1;
            }else if (prefixSum.containsKey(sum-targetSum)){
                left = prefixSum.get(sum-targetSum);
                length = i-left;
                left = left+1;
            }
            if(length>maxLength){
                maxLength = length;
                res = new int[]{left, i};
            }
            if(!prefixSum.containsKey(sum))
                prefixSum.put(Integer.valueOf(sum), Integer.valueOf(i));
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = longestSubarrayWithSum(new int[]{1, 2, 3, 4, 3, 3, 1, 2, 1}, 10);
        System.out.println(res[0]);
        System.out.println(res[1]);

        List<Integer> list = new ArrayList<>();
        list.toString();
    }
}
