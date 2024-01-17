package com.algorithm.practice.string.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// Ref: https://leetcode.com/problems/sort-characters-by-frequency/description/
// Ref: https://leetcode.com/problems/top-k-frequent-elements/description/
// Ref: https://leetcode.com/problems/top-k-frequent-words/description/

public class SortCharactersAccordingToFrequency {
    static String sortCharactersBucketSort(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        List<Character>[] bucket = new ArrayList[str.length()];
        for (Character c : map.keySet()) {
            bucket[map.get(c)] = new ArrayList<>();
            bucket[map.get(c)].add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null && bucket[i].size() > 0) {
                for (Character c : bucket[i]) {
                    int pos = i;
                    while (pos > 0) {
                        sb.append(c);
                        pos--;
                    }
                }
            }
        }
        return sb.toString();
    }

    // if freq same then here we follow alphabetic order
    // Time Complexity: O(nlogm) where m is fixed length the character set.
    // Enqueue and Deque operation takes log(n) time for priority queue

    static String sortCharactersPriorityQueue(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (b.getValue() == a.getValue()) {
                        return (int) a.getKey() - (int) b.getKey();
                    }
                    return b.getValue() - a.getValue();
                }
        );
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int) e.getValue(); i++)
                sb.append(e.getKey());
        }
        return sb.toString();
    }

    // There is a follow-up if you are interested, when same frequency we need to maintain the same sequence as the
    // character show in the original string, the solution is add a index as a secondary sort if the frequency is same,
    // code as below:

    public static String frequencySort(String s) {
        Map<Character, int[]> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) map.put(c, new int[]{1, i});
            else {
                int[] freqAndSeq = map.get(c);
                freqAndSeq[0]++;
                map.put(c, freqAndSeq);
            }
        }

        PriorityQueue<Map.Entry<Character, int[]>> pq = new PriorityQueue<>((a, b) ->
                a.getValue()[0] == b.getValue()[0] ? a.getValue()[1] - b.getValue()[1] : b.getValue()[0] - a.getValue()[0]);

        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, int[]> e = pq.poll();
            for (int i = 0; i < e.getValue()[0]; i++)
                sb.append(e.getKey());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(sortCharactersBucketSort("caabbb"));
        System.out.println(sortCharactersPriorityQueue("caadddbbb"));
        System.out.println(frequencySort("caadddbbb"));
        System.out.println(frequencySort("caadbdbdb"));
    }
}
