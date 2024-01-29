package com.algorithm.practice.linkedlist.hard;

//Ref: https://takeuforward.org/data-structure/reverse-linked-list-in-groups-of-size-k/
// Time: O(2N)
// Space : O(1)

import com.algorithm.practice.linkedlist.ConvertArrayToLinkedList;
import com.algorithm.practice.linkedlist.LinkedListNode;
import com.algorithm.practice.linkedlist.LinkedListReverse;
import com.algorithm.practice.linkedlist.LinkedListUtil;

public class ReverseLinkedListInGroupsOfSizeK {
    static LinkedListNode reverseK(LinkedListNode head, int k) {
        LinkedListNode current = head;
        LinkedListNode prevNode = null;
        while (current != null) {
            LinkedListNode kthNode = current;
            int revL = k;
            while (revL > 1) {
                kthNode = kthNode.next;
                revL--;
            }
            if (kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = current;
                }
                break;
            }
            LinkedListNode nextNode = kthNode.next;
            kthNode.next = null;
            LinkedListReverse.reverseIterative(current);
            if (current == head) {
                head = kthNode;
            } else {
                prevNode.next = kthNode;
            }
            prevNode = current;
            current = nextNode;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListUtil.printLinkedList(reverseK(ConvertArrayToLinkedList.convert(new int[]{1, 2, 3, 4, 5, 6}), 3));
    }
}
