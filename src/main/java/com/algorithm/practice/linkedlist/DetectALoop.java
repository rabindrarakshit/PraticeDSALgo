package com.algorithm.practice.linkedlist;

// Naive : Hashmap , Just put in new and check if already existing. if existing then there is a loop
// Time Complexity: O(N)
// Space Complexity: O(N)

// Below Optimal Solution
// Time Complexity: O(N)
// Space Complexity: O(1)

// Ref: https://takeuforward.org/data-structure/detect-a-cycle-in-a-linked-list/

public class DetectALoop {
    static boolean detectLoop(LinkedListNode head){
        LinkedListNode fast = head;
        LinkedListNode slow = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LinkedListNode node6 = new LinkedListNode(6);
        LinkedListNode node5 = new LinkedListNode(5, node6);
        LinkedListNode node4 = new LinkedListNode(4, node5);
        LinkedListNode node3 = new LinkedListNode(3, node4);
        LinkedListNode node2 = new LinkedListNode(2, node3);
        LinkedListNode node1 = new LinkedListNode(1, node2);
        node6.next = node3;
        System.out.println(detectLoop(node1));
    }
}
