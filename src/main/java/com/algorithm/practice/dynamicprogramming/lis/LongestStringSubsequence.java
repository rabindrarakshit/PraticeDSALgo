package com.algorithm.practice.dynamicprogramming.lis;

//Ref: https://takeuforward.org/data-structure/longest-string-chain-dp-45/

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringSubsequence {
    static int longest(String[] words) {
        int[] dp = new int[words.length];
        int[] sequences = new int[words.length];
        int maxi = 1;

        Arrays.sort(words, Comparator.comparingInt(String::length));
        Arrays.fill(dp, 1);

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (words[i].length() == words[j].length() + 1) {
                    int firstIndex = 0;
                    int comparingIndex = 0;
                    while (firstIndex < words[i].length()) {
                        if (comparingIndex < words[j].length() && (words[i].charAt(firstIndex) == words[j].charAt(comparingIndex))) {
                            firstIndex++;
                            comparingIndex++;
                        } else {
                            firstIndex++;
                        }
                    }
                    if ((firstIndex == words[i].length() && comparingIndex == words[j].length()) && (dp[j] + 1 > dp[i])) {
                        dp[i] = dp[j] + 1;
                        if (dp[i] > maxi) {
                            maxi = dp[i];
                        }
                        sequences[i] = j;
                    }
                }
            }
        }
        return maxi;
    }

    public static void main(String[] args) {
        System.out.println(longest(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}));
    }
}
