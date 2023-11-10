package com.algorithm.practice.hashsetmap;

import java.util.HashMap;
import java.util.Map;

// not sure if this works (Ref: Apna College)
// Looks like does not work for  int k=1; int arr[] = {0,1,-1,1,-1};
public class SubSequenceWithSumK {
    public static void main(String[] args) {
      //  int k = -10;
      //  int arr[] = {10, 2, -2, -20, 10};
        int k=1;
        int arr[] = {0,1,-1,1,-1};
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        Integer ans = 0;
        Integer sum = 0;
        for (int j = 0; j < arr.length; j++) {
            sum+=arr[j];
            if(map.containsKey(sum-k)){
                ans+=map.get(sum-k);
            }

            if(map.containsKey(sum)){
                map.put(sum, map.get(sum)+1);
            }else{
                map.put(sum,1);
            }
        }
        System.out.println(ans);
    }
}
