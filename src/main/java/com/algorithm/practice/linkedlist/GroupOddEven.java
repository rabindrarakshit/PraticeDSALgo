package com.algorithm.practice.linkedlist;

// Ref: https://leetcode.com/problems/odd-even-linked-list/description/

public class GroupOddEven {
    static LinkedListNode groupOddEven(LinkedListNode head) {
        LinkedListNode odd = head;
        LinkedListNode even = head.next;
        LinkedListNode evenHead = head.next;

        while(even!=null && even.next!=null){
            odd.next= odd.next.next;
            even.next = even.next.next;
            odd= odd.next;
            even = even.next;
        }
        odd.next=evenHead;
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode node6 = new LinkedListNode(6);
        LinkedListNode node5 = new LinkedListNode(5, node6);
        LinkedListNode node4 = new LinkedListNode(4, node5);
        LinkedListNode node3 = new LinkedListNode(3, node4);
        LinkedListNode node2 = new LinkedListNode(2, node3);
        LinkedListNode node1 = new LinkedListNode(1, node2);

        LinkedListUtil.printLinkedList(groupOddEven(node1));
    }
}
