package com.algorithm.practice.queue;
import java.util.Stack;
public class QueueUsingStack {
    Stack < Integer > input = new Stack < > ();
    Stack < Integer > output = new Stack < > ();
    /** Initialize your data structure here. */
    public QueueUsingStack() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (input.empty() == false) {
            output.push(input.peek());
            input.pop();
        }
        // Insert the desired element in the stack input
        System.out.println("The element pushed is " + x);
        input.push(x);
        // Pop out elements from the stack output and push them into the stack input
        while (output.empty() == false) {
            input.push(output.peek());
            output.pop();
        }

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // shift input to output
        if (input.empty()) {
            System.out.println("Stack is empty");

        }
        int val = input.peek();
        input.pop();
        return val;

    }

    /** Get the front element. */
    public int peek() {
        // shift input to output
        if (input.empty()) {
            System.out.println("Stack is empty");

        }
        return input.peek();
    }


    int size() {
        return input.size();
    }
}

class Test{
    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
        q.push(1);
        q.push(2);
        q.push(3);
    }
}
