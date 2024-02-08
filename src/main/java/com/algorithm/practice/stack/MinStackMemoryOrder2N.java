package com.algorithm.practice.stack;

public class MinStackMemoryOrder2N {
    private static Node head = null;

    static void push(int data) {
        if (head == null) {
            head = new Node(data, null, data);
        } else {
            Node node = new Node(data, head, Math.min(head.min, data));
            head = node;
        }
    }

    static void pop() {
        head = head.next;
    }

    static int top() {
        return head.data;
    }

    static int getMin() {
        return head.min;
    }

}

class Node {
    int data;
    Node next;
    int min;

    public Node(int data, Node next, int min) {
        this.data = data;
        this.next = next;
        this.min = min;
    }
}
