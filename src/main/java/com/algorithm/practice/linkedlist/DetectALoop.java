package com.algorithm.practice.linkedlist;

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
        LinkedListNode node2 = new LinkedListNode(1);
        LinkedListNode node1 = new LinkedListNode(2);
        node1.next = node2;
        LinkedListNode node3 = new LinkedListNode(3);
        node2.next = node3;
        node3.next = node1;
        System.out.println(detectLoop(node1));
    }
}
