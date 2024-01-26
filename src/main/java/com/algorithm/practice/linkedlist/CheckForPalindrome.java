package com.algorithm.practice.linkedlist;

// Red: https://takeuforward.org/data-structure/check-if-given-linked-list-is-plaindrome/
// Time Complexity: O(n)
// Space Complexity: O(1)

// Naive:  Use stack. In stack when you pop it is always in the reverse order. You simply have to compare again.

public class CheckForPalindrome {
    public static void main(String[] args) {
        LinkedListNode node6 = new LinkedListNode(1);
        LinkedListNode node5 = new LinkedListNode(2, node6);
        LinkedListNode node4 = new LinkedListNode(3, node5);
        LinkedListNode node3 = new LinkedListNode(3, node4);
        LinkedListNode node2 = new LinkedListNode(2, node3);
        LinkedListNode node1 = new LinkedListNode(1, node2);
        System.out.println(checkForPalindrome(node1));
    }

    static boolean checkForPalindrome(LinkedListNode head) {
        LinkedListNode center = FindCenter.findCenter(head);
        LinkedListNode current2 = LinkedListReverse.reverseIterative(center.next);
        LinkedListNode current1 = head;
        while (current2 != null) {
            if (current2.data != current1.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }
}
