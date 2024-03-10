package com.algorithm.practice.heap.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class FreqCount{
    int key;
    int count;

    public FreqCount(int key){
        this.key = key;
        this.count = 0;
    }
}
public class KMostFrequentElements {
    public static List<Integer> kMostFrequent(int[] nums, int k){
        PriorityQueue<FreqCount> pq = new PriorityQueue<FreqCount>((a,b) -> b.count - a.count);
        Map<Integer, FreqCount> map = new HashMap<>();
        for(int i:nums){
            FreqCount fq= map.getOrDefault(i,new FreqCount(i));
            fq.count++;
            map.put(i, fq);
        }
        for(Map.Entry<Integer, FreqCount> e: map.entrySet()){
            pq.add(e.getValue());
        }
        int count=0;
        List<Integer> result = new ArrayList<>();
        while(count<k || pq.isEmpty()){
            result.add(pq.poll().key);
            count++;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] array = new int[]{1,1,1,1,2,2,2,3,3,3,4,5};
        for(int i: kMostFrequent(array, 3)){
            System.out.print(i+" ");
        }
    }

    // Optimized Leetcode Solution
    public int[] topKFrequent(int[] nums, int k) {
        int minNum = nums[0], maxNum = nums[0];
        for (int num : nums) {
            if(num > maxNum){
                maxNum = num;
            } else if(num < minNum){
                minNum = num;
            }
        }

        int[] numAndCnt = new int[maxNum - minNum + 1];
        for (int num : nums) {
            numAndCnt[num - minNum]++;
        }

        List<Integer>[] cntAndNums = new List[nums.length + 1];
        for (int i = 0; i < numAndCnt.length; i++) {
            int numCnt = numAndCnt[i];
            if (cntAndNums[numCnt] == null) {
                cntAndNums[numCnt] = new ArrayList<>();
            }
            cntAndNums[numCnt].add(i + minNum);
        }

        int[] result = new int[k];
        for (int i = cntAndNums.length - 1; k > 0; i--) {
            if (cntAndNums[i] != null) {
                for (int num : cntAndNums[i]) {
                    result[--k] = num;
                    if (k == 0) {
                        break;
                    }
                }
            }
        }
        return result;

    }

}
