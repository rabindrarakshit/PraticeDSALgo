package com.algorithm.practice.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
    public static int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> freqMap = new HashMap<>();
        PriorityQueue<Map.Entry<Character,Integer>> freqSortHeap = new PriorityQueue<>(
                (a,b)-> a.getValue()!=b.getValue()? b.getValue()-a.getValue():a.getKey()-b.getKey());
        for(char task: tasks){
            freqMap.put(task, freqMap.getOrDefault(task,0)+1);
        }
        freqSortHeap.addAll(freqMap.entrySet());

        int count = 0;
        while(!freqSortHeap.isEmpty()){
            int k = n+1;
            List<Map.Entry> tempList = new ArrayList<>();
            while(k>0 && !freqSortHeap.isEmpty()){
                Map.Entry<Character, Integer> entry = freqSortHeap.poll();
                entry.setValue(entry.getValue()-1);
                tempList.add(entry);
                k--;
                count++;
            }
            for(Map.Entry<Character, Integer> entry: tempList){
                if(entry.getValue()>0){
                    freqSortHeap.add(entry);
                }
            }
            if(freqSortHeap.isEmpty()){
                break;
            }
            if(k>0){
                count+=k;
            }
        }
        return count;
    }

    public static int leastIntervalOptimized(char[] tasks, int n) {
        int[] charCount = new int[26];
        for (char c : tasks) {
            charCount[c - 'A']++;
        }
        //System.out.println(Arrays.toString(charCount));
        int maxFreq = 0;
        int maxFreqChars = 0;
        for (int count : charCount) {
            if (maxFreq < count) {
                maxFreq = count;
                maxFreqChars = 1;
            }
            else if (maxFreq == count) {
                maxFreqChars++;
            }
        }
        //System.out.println("maxFreq = " + maxFreq + " num of char = " + maxFreqChars);
        return Math.max(tasks.length,(maxFreq - 1)* (n + 1) + maxFreqChars);
    }

    public static void main(String[] args) {
        System.out.println(leastIntervalOptimized(new char[]{'A','A','A','B','B','B'}, 2));
    }
}
