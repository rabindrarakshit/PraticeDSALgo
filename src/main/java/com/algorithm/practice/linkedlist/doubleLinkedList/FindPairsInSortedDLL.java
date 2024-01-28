package com.algorithm.practice.linkedlist.doubleLinkedList;

// Naive1 : Start with one node and search all other next nodes Time : O(n^2), Space : O(1)
// Naive 2: May be store in HashSet (Not Tried) Time: O(n) Space O(n)

// Optimal Below: Two Pointer: Only because its sorted : Time : O(n) Space: O(1)

import java.util.ArrayList;
import java.util.List;

class Pair {
    int num1;
    int num2;

    Pair(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }
}

public class FindPairsInSortedDLL {
    static List<Pair> findPairs(DoubleLinkedListNode head, int sum) {
        DoubleLinkedListNode low = head;
        List<Pair> pairs = new ArrayList<>();
        while (low.next != null) {
            low = low.next;
        }
        DoubleLinkedListNode high = low;
        low = head;

        while (low != high) {
            int currentSum = low.data + high.data;
            if (currentSum == sum) {
                pairs.add(new Pair(low.data, high.data));
                low = low.next;
                high = high.prev;
            } else if (currentSum < sum) {
                low = low.next;
            } else {
                high = high.prev;
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        findPairs(ConvertArrayToDoubleLinkedList.convert(new int[]{1, 2, 3, 4, 5, 6}), 6).
                forEach((pair) -> {
                            System.out.print(pair.num1 + " " + pair.num2);
                            System.out.println();
                        });
    }
}
