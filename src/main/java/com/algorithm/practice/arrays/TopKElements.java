package com.algorithm.practice.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TopKElements {
    static String[] topKElements(String[] elements, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String s : elements) {
            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
        }
        List<String> bucket[] = new List[elements.length + 1];
        for (String key : freqMap.keySet()) {
            int count = freqMap.get(key);
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }
            bucket[count].add(key);
        }

        String[] result = new String[Math.min(freqMap.size(), k)];        // In case we want to return less than k elements, k could be greater than the number of distinct elements in nums.
        int resIdx = 0;
        for (int i = bucket.length - 1; i >= 0; --i) {
            if (bucket[i] == null) continue;
         //   Collections.sort(bucket[i]);
            for (String currNum : bucket[i]) {
                result[resIdx++] = currNum;
                if (resIdx == result.length) return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        for(String s: topKElements(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4)){
            System.out.println(s);
        }
        for(String s: topKElements(new String[]{"i","love","leetcode","i","love","coding"}, 2)){
            System.out.println(s);
        }
    }
}
