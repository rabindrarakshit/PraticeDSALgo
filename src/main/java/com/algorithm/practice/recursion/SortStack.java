package com.algorithm.practice.recursion;

import java.util.Stack;
import java.util.stream.Stream;

public class SortStack {
    static void pushSorted(int k, Stack<Integer> sortedStack) {
        if (sortedStack.isEmpty() || k > sortedStack.peek()) {
            sortedStack.push(k);
            return;
        }
        int top = sortedStack.pop();
        pushSorted(k, sortedStack);
        sortedStack.push(top);
    }

    static void reverseStack(Stack<Integer> stack, Stack<Integer> sortedStack) {
        if (stack.isEmpty()) {
            return;
        }
        int k = stack.pop();
        reverseStack(stack, sortedStack);
        pushSorted(k, sortedStack);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        Stream.of(5, 4, 3, 2, 1).forEach(e -> s.push(e));
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
        Stream.of(5, 4, 3, 2, 1).forEach(e -> s.push(e));
        System.out.println();
        Stack<Integer> sortedStack = new Stack();
        reverseStack(s, sortedStack);
        while (!sortedStack.isEmpty()) {
            System.out.print(sortedStack.pop() + " ");
        }
    }
}
