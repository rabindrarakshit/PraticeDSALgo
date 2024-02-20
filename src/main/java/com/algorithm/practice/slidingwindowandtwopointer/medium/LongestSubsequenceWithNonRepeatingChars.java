package com.algorithm.practice.slidingwindowandtwopointer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Ref: https://takeuforward.org/data-structure/length-of-longest-substring-without-any-repeating-character/

public class LongestSubsequenceWithNonRepeatingChars {

    // Time: O(n^2)
    // Space: O(n)
    static int longestSubSequence1(char[] arr) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < arr.length; j++) {
                if (set.contains(arr[j])) {
                    maxLength = Math.max(maxLength, j - i);
                    break;
                }
                set.add(arr[j]);
            }
        }
        return maxLength;
    }

    // Time: O(2N)
    // Space: O(N)
    static int longestSubSequence2(char[] arr) {
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        for (int l = 0, r = 0; r < arr.length; r++) {
            if (set.contains(arr[r])) {
                while (l < r && set.contains(arr[r])) {
                    l++;
                    set.remove(l);
                }
            }
            set.add(arr[r]);
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }

    // Time: O(N)
    // Space: O(N)
    static int longestSubsequence3(char[] arr) {
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int l = 0, r = 0; r < arr.length; r++) {
            if (map.containsKey(arr[r])) {
                l = Math.max(map.get(arr[r]) + 1, l);
            }
            map.put(arr[r], r);
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestSubsequence3(new char[]{'a', 'b', 'c', 'a', 'b', 'c', 'b', 'b'}));
    }
}
