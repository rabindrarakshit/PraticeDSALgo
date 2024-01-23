package com.algorithm.practice.linkedlist;

import java.util.HashSet;
import java.util.Set;

import static com.algorithm.practice.linkedlist.util.LinkedListUtil.*;

public class DeleteDuplicateWithExtraStorage {

    // Complexity : O(n)
    public static void deleteDuplicates(LinkedListNode node) {
        Set<Integer> hashSet = new HashSet<>();
        LinkedListNode prev = null;
        while (node != null) {
            if (hashSet.contains(node.data)) {
                prev.next = node.next;
            } else {
                hashSet.add(node.data);
                prev = node;
            }
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(1);
        LinkedListNode n3 = new LinkedListNode(2);
        LinkedListNode n4 = new LinkedListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        printLinkedList(n1);
        deleteDuplicates(n1);
        System.out.println("\n" + "Duplicates Deleted!!");
        printLinkedList(n1);

    }
}
