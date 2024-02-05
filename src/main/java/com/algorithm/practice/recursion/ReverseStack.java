package com.algorithm.practice.recursion;

import java.util.Stack;
import java.util.stream.Stream;

public class ReverseStack {
    static void reverseStack(Stack<Integer> stack, Stack<Integer> reverseStack) {
        if (!stack.isEmpty()) {
            int top = stack.pop();
            reverseStack.push(top);
            reverseStack(stack, reverseStack);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        Stream.of(5, 4, 3, 2, 1).forEach(e -> s.push(e));
        Stack<Integer> reverseStack = new Stack();
        reverseStack(s, reverseStack);
        while (!reverseStack.isEmpty()) {
            System.out.print(reverseStack.pop() + " ");
        }
    }
}
