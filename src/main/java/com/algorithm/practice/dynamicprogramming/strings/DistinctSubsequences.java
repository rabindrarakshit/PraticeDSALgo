package com.algorithm.practice.dynamicprogramming.strings;

//Ref: https://takeuforward.org/data-structure/distinct-subsequences-dp-32/
public class DistinctSubsequences {
    static int distinctSubsequences(String str1, String str2) {
        // Here we will count S2 presence in S1
        int prime = (int) (Math.pow(10, 9) + 7);
        int length1 = str1.length();
        int length2 = str2.length();
        int dp[][] = new int[length1 + 1][length2 + 1];
        for (int i = 0; i <= length1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= length2; i++) {
            dp[0][i] = 0;
        }
        for (int len1 = 1; len1 <= length1; len1++) {
            for (int len2 = 1; len2 <= length2; len2++) {
                if(str1.charAt(len1-1)==str2.charAt(len2-1)){
                    // If the characters match, we can either include this character in the subsequence
                    // or exclude it. So, we add the counts from both possibilities.
                    dp[len1][len2] = (dp[len1 - 1][len2 - 1] + dp[len1 - 1][len2])%prime;
                }else{
                    // If the characters don't match, we can only exclude this character.
                    dp[len1][len2] = dp[len1 - 1][len2];
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        System.out.println(distinctSubsequences("rabbbit","rabbit"));
    }
}
