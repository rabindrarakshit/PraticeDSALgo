package com.algorithm.practice.heap;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LaptopRentals {

    static int laptopRentals(List<List<Integer>> times){
        if(times.isEmpty()){
            return 0;
        }
        Collections.sort(times, Comparator.comparingInt(a -> a.get(0)));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(times.get(0).get(1));
        for(int i=1;i< times.size();i++){
            if(times.get(i).get(0)>=pq.peek()){
                pq.poll();
            }
            pq.add(times.get(i).get(1));
        }
        return pq.size();
    }

    // My solution
    static Integer minLaptops(List<List<Integer>> times){
         PriorityQueue<Integer> startingTimes = new PriorityQueue();
         PriorityQueue<Integer> endingTimes = new PriorityQueue();
         Integer laptops = 0;
         for(List<Integer> l: times){
             startingTimes.add(l.get(0));
             endingTimes.add(l.get(1));
         }
         while(!startingTimes.isEmpty()){
             if(startingTimes.peek()<endingTimes.peek()){
                 laptops++;
                 startingTimes.poll();
             }else{
                 endingTimes.poll();
                 startingTimes.poll();
             }
         }
         return laptops;
     }

    public static void main(String[] args) {
        List<List<Integer>> times = List.of(List.of(0,2),List.of(1,4),List.of(4,6),List.of(0,4),List.of(7,8),List.of(9,11),List.of(3,10));
        System.out.println(minLaptops(times));
    }
}
