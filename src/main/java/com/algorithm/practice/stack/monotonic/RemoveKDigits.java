package com.algorithm.practice.stack.monotonic;

// Ref: https://leetcode.com/problems/remove-k-digits/description/
// Time: O(N)
// Space : O(N)

import java.util.Stack;

public class RemoveKDigits {
    static String removeKDigits(String str, int k) {
        Stack<Character> stack = new Stack<>();
        if (k == str.length())
            return "0";

        for (int i = 0; i < str.length(); i++) {
            while (!stack.isEmpty() && stack.peek() > str.charAt(i) && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(str.charAt(i));
        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("1432219", 3));
    }
}
