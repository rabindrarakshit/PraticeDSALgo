package com.algorithm.practice.linkedlist.doubleLinkedList;

// Ref: https://www.youtube.com/watch?v=Mh0NH_SD92k
// Time Complexity: O(n)
// Space Complexity: O(1)

public class DeleteOccurrences {
    static DoubleLinkedListNode deleteOccurrences(DoubleLinkedListNode head, int data) {
        DoubleLinkedListNode current = head;
        while (current != null) {
            if (current.data == data) {
                if (current == head) {
                    head = current.next;
                }

                DoubleLinkedListNode prev = current.prev;
                DoubleLinkedListNode next = current.next;
                if (prev != null) {
                    prev.next = next;
                }
                if (current.next != null) {
                    next.prev = prev;
                }
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        DoubleLinkedListOperations.
                printDoubleLinkedList(deleteOccurrences(ConvertArrayToDoubleLinkedList.
                        convert(new int[]{1, 2, 3, 1, 5, 1}), 1));
    }
}
