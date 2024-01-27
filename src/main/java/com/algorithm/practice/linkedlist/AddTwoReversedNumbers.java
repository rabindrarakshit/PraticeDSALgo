package com.algorithm.practice.linkedlist;

// Ref: https://takeuforward.org/data-structure/add-two-numbers-represented-as-linked-lists/
// Time: O(max(m,n))
// Space : O(1)
public class AddTwoReversedNumbers {
    static LinkedListNode add(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode node1 = head1;
        LinkedListNode node2 = head2;
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode prev = dummy;
        int carry = 0;
        while (node1 != null || node2 != null || carry != 0) {
            int sum = 0;
            if (node1 != null) {
                sum += node1.data;
                node1 = node1.next;
            }
            if (node2 != null) {
                sum += node2.data;
                node2 = node2.next;
            }
            if (carry != 0) {
                sum += carry;
            }
            carry = sum / 10;
            LinkedListNode node = new LinkedListNode(sum % 10);
            prev.next = node;
            prev = prev.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedListUtil.printLinkedList(add(ConvertArrayToLinkedList.convert(new int[]{9, 9}),
                ConvertArrayToLinkedList.convert(new int[]{9, 9})));
    }
}
