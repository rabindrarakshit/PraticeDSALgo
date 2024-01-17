package com.algorithm.practice.string.easy;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    static boolean isIsomorphicStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            Character firstChar = str1.charAt(i);
            Character secondChar = str2.charAt(i);
            if (map.containsKey(firstChar)) {
                if (map.get(firstChar) == secondChar) {
                    continue;
                } else if (map.get(firstChar) != secondChar) {
                    return false;
                }
            }
            if (map.values().contains(secondChar)) {
                return false;
            }
            map.put(firstChar, secondChar);
        }
        return true;
    }

    static boolean isIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] strCount1 = new int[200];
        int[] strCount2 = new int[200];

        for (int j = 0; j < str1.length(); j++) {
            if (strCount1[str1.charAt(j)] != strCount2[str2.charAt(j)]) {
                return false;
            }
            strCount1[str1.charAt(j)] += 1;
            strCount2[str2.charAt(j)] += 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphicStrings("abc", "def"));
        System.out.println(isIsomorphicStrings("abb", "def"));
        System.out.println(isIsomorphicStrings("badc", "baba"));

        System.out.println(isIsomorphic("abc", "def"));
        System.out.println(isIsomorphic("abb", "def"));
        System.out.println(isIsomorphic("badc", "baba"));
    }
}
