package com.algorithm.practice.linkedlist;

// Ref: https://www.youtube.com/watch?v=I4g1qbkTPus

// Naive: Again this can be solved by hashmap by storing the length of each node in the map and then when we
// find the meeting point we just subtract the past length from current. Here we can a space complexity of O(N)


// Below Optimized solution
// Time Complexity: O(N)
// Space Complexity: O(1)

public class LengthOfLoop {
    static int lengthLoop(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;
        boolean firstMeet = false;
        int count = 0;
        while (fast != null && fast.next != null) {
            if (firstMeet) {
                count++;
            }
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                if (firstMeet) {
                    return count;
                }
                firstMeet = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LinkedListNode node6 = new LinkedListNode(6);
        LinkedListNode node5 = new LinkedListNode(5, node6);
        LinkedListNode node4 = new LinkedListNode(4, node5);
        LinkedListNode node3 = new LinkedListNode(3, node4);
        LinkedListNode node2 = new LinkedListNode(1, node3);
        LinkedListNode node1 = new LinkedListNode(2, node2);
        node6.next = node3;
        System.out.println(lengthLoop(node1));
    }
}
