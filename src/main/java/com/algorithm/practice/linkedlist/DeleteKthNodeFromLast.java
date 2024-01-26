package com.algorithm.practice.linkedlist;

public class DeleteKthNodeFromLast {
    static LinkedListNode deleteKthNodeFromLast(LinkedListNode head, int k) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;
        for (int i = 0; i < k; i++) {
            if (fast != null) {
                fast = fast.next;
            }
        }
        if (fast == null) {
            return head.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode node6 = new LinkedListNode(6);
        LinkedListNode node5 = new LinkedListNode(5, node6);
        LinkedListNode node4 = new LinkedListNode(4, node5);
        LinkedListNode node3 = new LinkedListNode(3, node4);
        LinkedListNode node2 = new LinkedListNode(2, node3);
        LinkedListNode node1 = new LinkedListNode(1, node2);

        LinkedListUtil.printLinkedList(deleteKthNodeFromLast(node1, 3));
    }
}
