package com.algorithm.practice.slidingwindowandtwopointer.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKUniqueCharacters {
    static int getLongestSubString(char[] arr, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            while (map.size() > k) {
                map.put(arr[j], map.get(arr[j]) - 1);
                map.remove(arr[j++], 0);
                max = Math.max(max, i - j + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getLongestSubString(new char[]{'a','a','b','b','c','c'}, 2));
    }
}
