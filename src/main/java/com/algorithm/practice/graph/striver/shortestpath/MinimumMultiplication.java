package com.algorithm.practice.graph.striver.shortestpath;

// Ref: https://takeuforward.org/graph/g-39-minimum-multiplications-to-reach-end/

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;



/*
* I initially solved it using Priority Queue. And it gives correct result. Sorted it using count and hence in the first match we will
* always have the least count.
*
* Got a TLE in GFG.
*
* Used the distance array and normal Queue. Still got a TLE.
*
* */

public class MinimumMultiplication {

    static class Pair {
        int number;
        int count;

        Pair(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }

    static int minMultiplication(int start, int end, int[] input) {
        // PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(p -> p.count));

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, 0));
        int mod = (int) 1e5;

        int[] dist = new int[100000];
        for (int i = 0; i < 100000; i++) dist[i] = (int) (1e9);
        dist[start] = 0;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < input.length; i++) {
                int currentData = (p.number * input[i]) % mod;
                if (p.count + 1 < dist[currentData]) {
                    dist[currentData] = p.count + 1;
                }

                if (currentData == end) {
                    return dist[currentData];
                }

                q.add(new Pair(currentData, p.count + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(minMultiplication(3, 30, new int[]{2, 5, 7}));
        System.out.println(minMultiplication(7, 66175, new int[]{3, 4, 65}));
    }
}
