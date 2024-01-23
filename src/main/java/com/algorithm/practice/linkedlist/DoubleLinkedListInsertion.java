package com.algorithm.practice.linkedlist;

public class DoubleLinkedListInsertion {
    static DoubleLinkedListNode insertEnd(DoubleLinkedListNode head, int data) {
        DoubleLinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        DoubleLinkedListNode newNode = new DoubleLinkedListNode(data);
        current.next = newNode;
        newNode.prev = current;
        return head;
    }

    static DoubleLinkedListNode deleteEnd(DoubleLinkedListNode head) {
        DoubleLinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        DoubleLinkedListNode tail = current;
        DoubleLinkedListNode prev = tail.prev;
        tail.prev = null;
        prev.next = null;
        return head;
    }

    static DoubleLinkedListNode reverse(DoubleLinkedListNode head) {
       DoubleLinkedListNode current = head;
       DoubleLinkedListNode prev=null;
       while(current!=null){
           prev = current.prev;
           current.prev = current.next;
           current.next = prev;
           current = current.prev;
       }
       return prev.prev;
    }

    static void printDoubleLinkedList(DoubleLinkedListNode head) {
        DoubleLinkedListNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    static DoubleLinkedListNode createSampleDoubleLinkedList() {
        DoubleLinkedListNode node4 = new DoubleLinkedListNode(4);
        DoubleLinkedListNode node2 = new DoubleLinkedListNode(2);
        DoubleLinkedListNode node3 = new DoubleLinkedListNode(3, node2, node4);
        DoubleLinkedListNode node1 = new DoubleLinkedListNode(1, null, node2);
        node2.next = node3;
        node2.prev = node1;
        node1.next = node2;
        node4.prev = node3;
        return node1;
    }

    public static void main(String[] args) {
        DoubleLinkedListNode head = createSampleDoubleLinkedList();
        printDoubleLinkedList(head);
        insertEnd(head, 5);
        printDoubleLinkedList(head);
        deleteEnd(head);
        printDoubleLinkedList(head);
        head = reverse(head);
        printDoubleLinkedList(head);

    }
}
