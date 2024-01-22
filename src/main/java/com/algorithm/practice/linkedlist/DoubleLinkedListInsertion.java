package com.algorithm.practice.linkedlist;

public class DoubleLinkedListInsertion {
    static DoubleLinkedListNode insertEnd(DoubleLinkedListNode head, int data) {
        DoubleLinkedListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new DoubleLinkedListNode(data);;
        return head;
    }

    static void printDoubleLinkedList(DoubleLinkedListNode head) {
        DoubleLinkedListNode current = head;
        while (current != null) {
            System.out.println(current.data);
            current=current.next;
        }
    }

    static DoubleLinkedListNode createSampleDoubleLinkedList(){
        DoubleLinkedListNode node4 = new DoubleLinkedListNode(4);
        DoubleLinkedListNode node2 = new DoubleLinkedListNode(2);
        DoubleLinkedListNode node3 = new DoubleLinkedListNode(3,node2, node4);
        DoubleLinkedListNode node1 = new DoubleLinkedListNode(1, null, node2);
        node2.next = node3;
        node2.prev = node1;
        node1.next = node2;
        return node1;
    }

    public static void main(String[] args) {
        DoubleLinkedListNode head = createSampleDoubleLinkedList();
        printDoubleLinkedList(head);
    }
}
