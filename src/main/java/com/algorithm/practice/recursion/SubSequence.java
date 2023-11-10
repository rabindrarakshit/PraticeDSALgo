package com.algorithm.practice.recursion;

import java.util.HashSet;
import java.util.Set;

public class SubSequence {
    public static void main(String[] args) {
        for (String str : subSequence("123", 0, "", new HashSet<String>())) {
            System.out.println(str);
        }
    }

    public static Set<String> subSequence(String str, int index, String newString, Set<String> set) {
        if (index == str.length()) {
            if (!set.contains(newString))
                set.add(newString);
            return set;
        }
        set = subSequence(str, index + 1, newString + str.charAt(index), set);
        set = subSequence(str, index + 1, newString, set);
        return set;
    }
}
