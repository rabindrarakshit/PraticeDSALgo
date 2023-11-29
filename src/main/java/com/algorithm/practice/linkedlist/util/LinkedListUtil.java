package com.algorithm.practice.linkedlist.util;

public class LinkedListUtil {
    public static String test_static = "";

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void printLinkedList(Node node) {
        while (node != null) {
            System.out.print("\n" + node.data + " ");
            node = node.next;
        }
    }
}
