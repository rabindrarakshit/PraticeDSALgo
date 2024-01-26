package com.algorithm.practice.linkedlist.doubleLinkedList;

public class DoubleLinkedListNode {
    DoubleLinkedListNode prev;
    DoubleLinkedListNode next;

    int data;

    public DoubleLinkedListNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public DoubleLinkedListNode(int data, DoubleLinkedListNode prev, DoubleLinkedListNode next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
