package com.algorithm.practice.linkedlist.doubleLinkedList;

// Ref:https://www.youtube.com/watch?v=YJKVTnOJXSY&t=2s
// Both algo below has time complexity of O(n) and space complexity of O(1)
public class RemoveDuplicatesFromSortedDLL {
    static DoubleLinkedListNode removeDuplicatesFromSortedDLL(DoubleLinkedListNode head) {
        DoubleLinkedListNode current = head.next;
        while (current != null) {
            if (current.data == head.data) {
                head = head.next;
            }
            DoubleLinkedListNode prev = current.prev;
            DoubleLinkedListNode next = current.next;
            if (next != null && current.data == next.data) {
                prev.next = next;
                next.prev = prev;
            }
            current = current.next;
        }
        return head;
    }

    static DoubleLinkedListNode removeDuplicatesFromSortedDLLOptimized(DoubleLinkedListNode head) {
        DoubleLinkedListNode current = head;
        DoubleLinkedListNode nextNode = null;
        while (current != null && current.next != null) {
            nextNode = current.next;
            while (nextNode != null && current.data == nextNode.data) {
                nextNode = nextNode.next;
            }
            current.next = nextNode;
            if (nextNode != null) {
                nextNode.prev = current;
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        DoubleLinkedListOperations.printDoubleLinkedList(
                removeDuplicatesFromSortedDLL(ConvertArrayToDoubleLinkedList.convert(new int[]{1, 1, 2, 2, 2, 3, 4})));
        DoubleLinkedListOperations.printDoubleLinkedList(
                removeDuplicatesFromSortedDLLOptimized(ConvertArrayToDoubleLinkedList.convert(new int[]{1, 1, 2, 2, 2, 3, 4})));
    }
}
