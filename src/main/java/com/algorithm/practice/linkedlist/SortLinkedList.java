package com.algorithm.practice.linkedlist;

// Ref: https://leetcode.com/problems/sort-list/description/
// Time Complexity: O(nlog(n))
// Space Complexity: O(1)

public class SortLinkedList {
    static LinkedListNode mergeSort(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        LinkedListNode node1 = mergeSort(head);
        LinkedListNode node2 = mergeSort(slow);
        return merge(node1, node2);
    }

    static LinkedListNode merge(LinkedListNode head, LinkedListNode nextHead) {
        LinkedListNode l = new LinkedListNode(0);
        LinkedListNode p = l;

        while (head != null && nextHead != null) {
            if (head.data <= nextHead.data) {
                p.next = head;
                head = head.next;
            } else {
                p.next = nextHead;
                nextHead = nextHead.next;
            }
            p = p.next;
        }
        if (head != null) {
            p.next = head;
        }
        if (nextHead != null) {
            p.next = nextHead;
        }
        return l.next;
    }

    public static void main(String[] args) {
        LinkedListNode head = ConvertArrayToLinkedList.convert(new int[]{5, 4, 3, 2, 1});
        LinkedListUtil.printLinkedList(mergeSort(head));
    }
}
