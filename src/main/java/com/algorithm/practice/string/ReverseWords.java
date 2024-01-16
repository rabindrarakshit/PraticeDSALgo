package com.algorithm.practice.string;

// Ref: https://takeuforward.org/data-structure/reverse-words-in-a-string/

// Input: s=”this is an amazing program”
// Output: “program amazing an is this”

public class ReverseWords {
    // Another approach is using stack
    // Below approach is without using external memory

    static String reverseWordsOptimized(String str) {
        StringBuilder temp = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                temp.append(str.charAt(i));
            } else {
                if (result.length() == 0) {
                    result.append(temp);
                } else {
                    result = temp.append(" " + result);
                }
                temp = new StringBuilder();
            }
        }
        if (temp.length() > 0) {
            if (result.length() == 0) {
                result.append(temp);
            } else {
                result = temp.append(" " + result);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "Interviewing Sucks Man!!";
        System.out.println(reverseWordsOptimized(str));
    }
}
