package com.algorithm.practice.slidingwindowandtwopointer.medium;

// Ref: https://leetcode.com/problems/longest-repeating-character-replacement/description/
// Here the difference is we can replace any character
public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int count[] = new int[26];
        int i = 0, j = 0;
        int max = 0;
        for (j = 0; j < s.length(); j++) {
            max = Math.max(max, ++count[s.charAt(j) - 'A']);
            if ((j - i + 1) > (max + k)) {
                count[s.charAt(i++) - 'A']--;
            }
        }
        return s.length() - i;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("AABBBC", 2));
    }
}
