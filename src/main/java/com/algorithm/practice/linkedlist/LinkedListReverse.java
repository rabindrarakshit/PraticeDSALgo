package com.algorithm.practice.linkedlist;

public class LinkedListReverse {
    static LinkedListNode reverseRecursive(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode newHead = reverseRecursive(head.next);
        LinkedListNode front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static LinkedListNode reverseIterative(LinkedListNode head) {
        LinkedListNode current = head;
        LinkedListNode prev = null;
        while (current != null) {
           LinkedListNode front = current.next;
           current.next=prev;
           prev = current;
           current=front;
        }
        return prev;
    }

    public static void main(String[] args) {
        LinkedListUtil.printLinkedList(reverseRecursive(ConvertArrayToLinkedList.convert(new int[]{1, 2, 3, 4})));
        System.out.println();
        LinkedListUtil.printLinkedList(reverseIterative(ConvertArrayToLinkedList.convert(new int[]{1, 2, 3, 4})));
    }
}
