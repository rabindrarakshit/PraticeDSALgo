package com.algorithm.practice.dynamicprogramming.strings;

// Ref: https://takeuforward.org/data-structure/longest-palindromic-subsequence-dp-28/

public class LongestPalindromeSubSequence {

    // Striver
    static int longest(String str1){
        String str2 = new StringBuilder(str1).reverse().toString();
        int prev[] = new int[str2.length() + 1];
        int current[] = new int[str2.length() + 1];
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    current[j] = 1 + prev[j - 1];
                } else {
                    current[j] = Math.max(prev[j], current[j-1]);
                }
            }
            prev = current.clone();
        }
        return prev[str2.length()];
    }

    // Optimized DP Solution
    public int longestPalindromeSubseq(String s) {
        char []s1=s.toCharArray();
        int n=s1.length;
        int dp[]=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            dp[i]=1;
            int currMax=0;
            for(int j=i-1;j>=0;j--){
                int curr=dp[j];
                if(s1[j]==s1[i]){
                    dp[j]=2+currMax;
                }
                currMax=Math.max(currMax,curr);
            }
        }
        int max=0;
        for(int i:dp){
            max=Math.max(max,i);
        }
        return max;
    }
}
