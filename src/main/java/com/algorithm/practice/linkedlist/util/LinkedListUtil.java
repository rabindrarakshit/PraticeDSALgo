package com.algorithm.practice.linkedlist.util;

import com.algorithm.practice.linkedlist.LinkedListNode;

public class LinkedListUtil {
    public static void printLinkedList(LinkedListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
}
