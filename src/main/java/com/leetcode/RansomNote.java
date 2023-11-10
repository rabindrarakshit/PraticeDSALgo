package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        canConstruct("aa", "aab");
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (Character c : magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }
        for (Character c : ransomNote.toCharArray()) {
            if (magazineMap.get(c) == null) {
                return false;
            }
            if (ransomMap.get(c) >= magazineMap.get(c)) {
                return false;
            }
            ransomMap.put(c, ransomMap.getOrDefault(c, 0) + 1);
        }
        return true;
    }
}
