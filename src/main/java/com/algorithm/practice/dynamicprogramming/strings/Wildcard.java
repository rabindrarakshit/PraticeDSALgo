package com.algorithm.practice.dynamicprogramming.strings;

public class Wildcard {

    // My Wrong Implementation : Cannot be solved by subsequence
    /*static boolean wildcard(String str1, String str2){
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
        int lcs = prev[str2.length()];
        int count = 0;
        for(char ch: str1.toCharArray()){
            if(Character.isLetterOrDigit(ch)) count++;
        }
        return count==lcs;
    }*/

    public static boolean isMatch(String str, String pattern) {
        int length1 = pattern.length();
        int length2 = str.length();
        boolean[][] dp = new boolean[length1 + 1][length2 + 1];

        //BaseCase
        dp[0][0] = true;
        for (int len2 = 1; len2 <= length2; len2++) {
            dp[0][len2] = false;
        }
        for (int len1 = 1; len1 <= length1; len1++) {
            dp[len1][0] = isAllStars(pattern, 0, len1 - 1);
        }

        for (int len1 = 1; len1 <= length1; len1++) {
            for (int len2 = 1; len2 <= length2; len2++) {
                if ((pattern.charAt(len1 - 1) == str.charAt(len2 - 1)) || (pattern.charAt(len1 - 1) == '?')) {
                    dp[len1][len2] = dp[len1 - 1][len2 - 1];
                } else {
                    if (pattern.charAt(len1 - 1) == '*') {
                        dp[len1][len2] = dp[len1 - 1][len2] || dp[len1][len2 - 1];
                    } else {
                        dp[len1][len2] = false;
                    }
                }
            }
        }
        return dp[length1][length2];
    }

    static boolean isAllStars(String str, int i, int j) {
        for (int index = i; index <= j; index++) {
            if (str.charAt(index) != '*') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("zacabz", "*a?b*"));
    }
}
