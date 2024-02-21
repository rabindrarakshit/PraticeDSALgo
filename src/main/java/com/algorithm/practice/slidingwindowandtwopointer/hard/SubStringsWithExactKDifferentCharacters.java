package com.algorithm.practice.slidingwindowandtwopointer.hard;

import java.util.HashMap;
import java.util.Map;

//Ref: https://leetcode.com/problems/subarrays-with-k-different-integers/description/
// Time: O(N)
// Space : O(N)
public class SubStringsWithExactKDifferentCharacters {
    static int getValidSubStrings(int[] arr, int k){
        return getValidSubStrings2(arr, k) - getValidSubStrings2(arr,k-1);
    }

    static int getValidSubStrings2(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int i=0,j=0, n = arr.length, res =0;
        for(;j<n;j++){
            // condition
            if(map.getOrDefault(arr[j],0)==0){k--;}
            map.put(arr[j], map.getOrDefault(arr[j],0)+1);
            // moving the window
            while(k<0){
                map.put(arr[i], map.get(arr[i])-1);
                if(map.get(arr[i++])==0){k++;}
            }
            res+=(j-i+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getValidSubStrings(new int[]{1,2,1,2,3}, 2));
    }
}
