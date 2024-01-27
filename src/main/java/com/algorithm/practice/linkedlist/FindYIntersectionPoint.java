package com.algorithm.practice.linkedlist;

//Ref: https://takeuforward.org/data-structure/find-intersection-of-two-linked-lists/

// Solution 1: Traverse the entire second list for each element of the first list Time : O(mn) Space O(1)
// Solution 2: Traverse through one list, put it in a hashset and then traverse the second and find match in hashset O(m+n) Space O(m or n)
// Solution 3: Get the length of both lists. Find the diff. Put the head on the diff of the longer list and then traverse
// together : O(m)+O(m-n)+O(n) considering m>n Space: O(1)

// Solution 4: Below. Time : O(m+n) Space: O(1)
public class FindYIntersectionPoint {
    static LinkedListNode findIntersection(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode node1 = head1;
        LinkedListNode node2 = head2;
        while (node1 != node2) {
            if (node1 == null) {
                node1 = head2;
            } else {
                node1 = node1.next;
            }
            if (node2 == null) {
                node2 = head1;
            } else {
                node2 = node2.next;
            }
        }
        return node1;
    }

    public static void main(String[] args) {
        LinkedListNode node6 = new LinkedListNode(6);
        LinkedListNode node5 = new LinkedListNode(5, node6);
        LinkedListNode node4 = new LinkedListNode(4, node5);
        LinkedListNode node3 = new LinkedListNode(3, node4);
        LinkedListNode node2 = new LinkedListNode(2, node3);
        LinkedListNode node1 = new LinkedListNode(1, node2);

        LinkedListNode node7 = new LinkedListNode(2, node4);

        System.out.println(findIntersection(node1, node7).data);
    }
}
