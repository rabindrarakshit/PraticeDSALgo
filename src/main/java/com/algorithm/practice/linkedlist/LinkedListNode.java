package com.algorithm.practice.linkedlist;

public class LinkedListNode {
    public int data;
    public LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
    public LinkedListNode(int data, LinkedListNode next) {
        this.data = data;
        this.next = next;
    }
}