package com.algorithm.practice.linkedlist;

// Ref: https://www.youtube.com/watch?v=gRII7LhdJWc

// Naive solution with two pass, go through the list count 0,1,2. And then go through the counts and form a list

// Optimized
// Time Complexity: O(n) : One pass
// Space Complexity: O(1)

// For Array we solved this with Dutch National Flag Algorithm

public class Sort012 {
    static LinkedListNode sort012(LinkedListNode head) {
        LinkedListNode dummyZero = new LinkedListNode(-1);
        LinkedListNode dummyOne = new LinkedListNode(-1);
        LinkedListNode dummyTwo = new LinkedListNode(-1);

        LinkedListNode one = dummyOne;
        LinkedListNode two = dummyTwo;
        LinkedListNode zero = dummyZero;

        LinkedListNode current = head;
        while (current != null) {
            if (current.data == 0) {
                zero.next = current;
                zero = zero.next;
            } else if (current.data == 1) {
                one.next = current;
                one = one.next;
            } else {
                two.next = current;
                two = two.next;
            }
            current = current.next;
        }
        zero.next = dummyOne.next;
        one.next = dummyTwo.next;
        two.next = null;
        return dummyZero.next;
    }

    public static void main(String[] args) {
        LinkedListNode head = ConvertArrayToLinkedList.convert(new int[]{2, 1, 0, 2, 1, 0});
        LinkedListUtil.printLinkedList(sort012(head));
    }
}
