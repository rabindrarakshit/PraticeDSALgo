package com.algorithm.practice.linkedlist;

import static com.algorithm.practice.linkedlist.LinkedListUtil.*;

public class DeleteDuplicateWithoutExtraStorage {
    public static void deleteDuplicates(LinkedListNode node) {
        LinkedListNode current = node;
        LinkedListNode runner;
        while (current != null) {
            runner = current;
            while (runner.next != null) {
                // The below if else is quite unique. When it finds a match it removes the next element
                // and does not move the pointer to the next node. It only moves the pointer when there is no match
                // And in while we check runner.next != null

                if (current.data == runner.next.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
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
