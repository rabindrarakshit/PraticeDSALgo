package com.algorithm.practice.stack;

import java.util.Stack;

// Ref: https://takeuforward.org/data-structure/infix-to-prefix/
// time : O(n) : reverse + O(n) : traverse + O(n) : reverse
// space : O(n)

public class InfixToPrefix {

    static int precedences(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    static String convert(String infix) {
        String reversedString = reverse(infix);
        Stack<Character> stack = new Stack<>();
        StringBuilder postFix = new StringBuilder();

        for (int i = 0; i < reversedString.length(); i++) {
            char cur = reversedString.charAt(i);
            if (Character.isLetterOrDigit(cur)) {
                postFix.append(cur);
            } else if (cur == ')') {
                stack.push(cur);
            } else if (cur == '(') {
                while (!stack.isEmpty() && stack.peek() != ')') {
                    postFix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedences(cur) <= precedences(stack.peek())) {
                    postFix.append(stack.pop());
                }
                stack.push(cur);
            }
        }
        while (!stack.isEmpty()) {
            postFix.append(stack.pop());
        }
        return reverse(postFix.toString());
    }

    public static void main(String[] args) {
        System.out.println(convert("a+b"));
        System.out.println(convert("a+b*c"));
        System.out.println(convert("a*b+c"));
        System.out.println(convert("(a+b)*c"));
    }
}

