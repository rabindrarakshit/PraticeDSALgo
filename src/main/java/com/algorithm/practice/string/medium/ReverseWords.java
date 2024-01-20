package com.algorithm.practice.string.medium;

// Time Complexity: O(n)
// Space Complexity: O(1)

// Ref: https://leetcode.com/problems/reverse-words-in-a-string/
// Given an input string s, reverse the order of the words.
// Input: " A good    example "
// output: "example good A"
// All extra spaces needs to be removed

public class ReverseWords {
    static String reverseWordsInString(String str) {
        char[] sentence = str.toCharArray();
        reverse(sentence, 0, str.length() - 1);
        reverseWords(sentence);
        return cleanSpace(sentence);
    }

    static void reverse(char[] sentence, int begin, int end) {
        while (begin < end) {
            char temp = sentence[begin];
            sentence[begin++] = sentence[end];
            sentence[end--] = temp;
        }
    }

    static void reverseWords(char[] sentence) {
        int i = 0, j = 0;
        while (i < sentence.length) {
            while (i < j || (i < sentence.length && sentence[i] == ' ')) {
                i++;
            }
            while (j < i || (j < sentence.length && sentence[j] != ' ')) {
                j++;
            }
            reverse(sentence, i, j - 1);
        }
    }

    static String cleanSpace(char[] a) {
        int n = a.length;
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && a[j] == ' ') j++;             // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
            while (j < n && a[j] == ' ') j++;             // skip spaces
            if (j < n) a[i++] = ' ';                      // keep only one space
        }

        return new String(a).substring(0, i);
    }

    public static void main(String[] args) {
        System.out.print(reverseWordsInString(" A good    example "));
    }

}
