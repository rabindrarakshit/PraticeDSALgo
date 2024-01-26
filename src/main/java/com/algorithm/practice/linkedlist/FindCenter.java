package com.algorithm.practice.linkedlist;

public class FindCenter {
    static LinkedListNode findCenter(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        LinkedListNode node6 = new LinkedListNode(6);
        LinkedListNode node5 = new LinkedListNode(5, node6);
        LinkedListNode node4 = new LinkedListNode(4, node5);
        LinkedListNode node3 = new LinkedListNode(3, node4);
        LinkedListNode node2 = new LinkedListNode(2, node3);
        LinkedListNode node1 = new LinkedListNode(1, node2);

        System.out.println(findCenter(node1).data);
    }
}
