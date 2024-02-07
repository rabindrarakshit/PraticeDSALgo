package com.algorithm.practice.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {
    Queue<Integer> q = new LinkedList<>();

    void push(int data) {
        q.offer(data);
        for (int i = 0; i < q.size() - 1; i++) {
            q.offer(q.remove());
        }
    }

    int pop() {
        if (!q.isEmpty())
            return q.remove();
        return -1;
    }

    int peek() {
        return q.peek();
    }

    int size() {
        return q.size();
    }
}
