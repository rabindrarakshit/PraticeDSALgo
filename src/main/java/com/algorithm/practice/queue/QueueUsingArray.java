package com.algorithm.practice.queue;

public class QueueUsingArray {
    int start = -1, end = -1, maxSize = 5, currSize = 0;
    int[] arr = new int[10000];

    void push(int data) {
        if (currSize == maxSize) {
            System.out.println("Queue is full\nExiting...");
            System.exit(1);
        }
        if (end == -1) {
            start = 0;
            end = 0;
        } else {
            end = (end + 1) % maxSize;
        }
        arr[end] = data;
        currSize++;
    }

    void pop() {
        if (start == -1) {
            System.out.println("Queue Empty\nExiting...");
            System.exit(1);
        }
        if (currSize == 1) {
            start = -1;
            end = -1;
        } else
            start = (start + 1) % maxSize;
        currSize--;
    }

    int peek() {
        if (start == -1) {
            System.out.println("Queue is Empty");
            System.exit(1);
        }
        return arr[start];
    }

    int size() {
        return currSize;
    }

}

