package com.algorithm.practice.heap;

import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

// Ref: https://leetcode.com/problems/hand-of-straights/description/

public class HandOfStraights {
    // Time: O(nlog(k) + n^2)
    // Space: O(n)
    static boolean isNStraightHand(int[] array, int w) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : array) {
            minHeap.add(i);
        }
        while (!minHeap.isEmpty()) {
            int currentHand = minHeap.poll();
            for (int i = 1; i < w; i++) {
                if (!minHeap.remove(currentHand + i)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Leetcode Optimized
    // Time : O(MlogM + N)
    /*
    * Solution 2:
Count number of different cards to a map c
Cur represent current open straight groups.
In a deque start, we record the number of opened a straight group.
Loop from the smallest card number.
For example, hand = [1,2,3,2,3,4], W = 3
We meet one 1:
opened = 0, we open a new straight groups starting at 1, push (1,1) to start.
We meet two 2:
opened = 1, we need open another straight groups starting at 1, push (2,1) to start.
We meet two 3:
opened = 2, it match current opened groups.
We open one group at 1, now we close it. opened = opened - 1 = 1
We meet one 4:
opened = 1, it match current opened groups.
We open one group at 2, now we close it. opened = opened - 1 = 0

return if no more open groups.
Complexity
O(MlogM + N), where M is the number of different cards.
Because I count and sort cards.
In Cpp and Java it's O(NlogM), which can also be improved.
    * */
    public boolean isNStraightHandOptimized(int[] hand, int W) {
        Map<Integer, Integer> c = new TreeMap<>();
        for (int i : hand) c.put(i, c.getOrDefault(i, 0) + 1);
        Queue<Integer> start = new LinkedList<>();
        int last_checked = -1, opened = 0;
        for (int i : c.keySet()) {
            if (opened > 0 && i > last_checked + 1 || opened > c.get(i)) return false;
            start.add(c.get(i) - opened);
            last_checked = i;
            opened = c.get(i);
            if (start.size() == W) opened -= start.remove();
        }
        return opened == 0;
    }

    public static void main(String[] args) {
        System.out.println(isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3));
    }
}
