package com.ctci.linkedlist;

import java.util.HashSet;
import java.util.Set;

import static com.ctci.linkedlist.util.LinkedListUtil.*;

public class DeleteDuplicateWithExtraStorage {

    // Complexity : O(n)
    public static void deleteDuplicates(Node node) {
        Set<Integer> hashSet = new HashSet<>();
        Node prev = null;
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
        Node n1 = new Node(1);
        Node n2 = new Node(1);
        Node n3 = new Node(2);
        Node n4 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        printLinkedList(n1);
        deleteDuplicates(n1);
        System.out.println("\n" + "Duplicates Deleted!!");
        printLinkedList(n1);

    }
}
