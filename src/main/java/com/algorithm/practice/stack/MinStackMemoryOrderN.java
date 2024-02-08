package com.algorithm.practice.stack;

import java.util.Stack;

public class MinStackMemoryOrderN {
    static Stack<Integer> stack = new Stack<>();
    static int min = 100;

    static void push(int data) {
        if (stack.isEmpty()) {
            min = data;
            stack.push(data);
        } else {
            if (data < min) {
                stack.push(2 * data - min); // This logic is mind-blowing, how they are maintaining the prev min
                min = data;
            } else {
                stack.push(data);
            }
        }
    }

    static int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int data = stack.pop();
        int temp = -1;
        if (data < min) {
            temp = min;
            min = 2 * min - data; // also look here
        }
        return temp;
    }

    public int top() {
        int val = stack.peek();
        if (val < min) {
            return min;
        }
        return val;
    }

    static int minElement() {
        return min;
    }

    public static void main(String[] args) {
        MinStackMemoryOrderN minStackMemoryOrderN = new MinStackMemoryOrderN();
        minStackMemoryOrderN.push(3);
        minStackMemoryOrderN.push(2);
        minStackMemoryOrderN.push(5);
        System.out.println(minStackMemoryOrderN.min);
        minStackMemoryOrderN.pop();
        minStackMemoryOrderN.pop();
        System.out.println(minStackMemoryOrderN.min);
    }
}
