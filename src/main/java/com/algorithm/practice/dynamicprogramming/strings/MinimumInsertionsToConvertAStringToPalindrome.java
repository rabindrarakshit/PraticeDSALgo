package com.algorithm.practice.dynamicprogramming.strings;

// Ref: https://takeuforward.org/data-structure/minimum-insertions-to-make-string-palindrome-dp-29/

public class MinimumInsertionsToConvertAStringToPalindrome {
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
        return str1.length()-prev[str2.length()];
    }
}
