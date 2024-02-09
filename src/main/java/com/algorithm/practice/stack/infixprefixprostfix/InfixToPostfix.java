package com.algorithm.practice.stack.infixprefixprostfix;

import java.util.Stack;

public class InfixToPostfix {
    static int precedence(char ch) {
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

    static String convert(String infix) {
        StringBuilder postFix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char cur = infix.charAt(i);
            if (Character.isLetterOrDigit(cur)) {
                postFix.append(cur);
            } else if (cur == '(') {
                stack.push('(');
            } else if (cur == ')') {
                while(!stack.isEmpty() && stack.peek()!='('){
                    postFix.append(stack.pop());
                }
                // This pops '('
                stack.pop();
            } else{
                // we have an operator
                while(!stack.isEmpty() && precedence(cur)<=precedence(stack.peek())){
                    postFix.append(stack.pop());
                }
                stack.push(cur);
            }
        }
        while(!stack.isEmpty()){
            postFix.append(stack.pop());
        }
        return postFix.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("a+b"));
        System.out.println(convert("a+b*c"));
        System.out.println(convert("a*b+c"));
        System.out.println(convert("(a+b)*c"));
    }
}
