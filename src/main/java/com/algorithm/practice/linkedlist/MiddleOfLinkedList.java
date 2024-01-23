package com.algorithm.practice.linkedlist;

public class MiddleOfLinkedList {
    static LinkedListNode middle(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(middle(ConvertArrayToLinkedList.convert(new int[]{1, 2, 3, 4, 5})).data);
        System.out.println(middle(ConvertArrayToLinkedList.convert(new int[]{1, 2, 3, 4})).data);
    }
}
