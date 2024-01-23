package com.algorithm.practice.linkedlist;

public class ReturnKToLastRecursive {

    static class Index {
        int index;

        Index() {
            this.index = 0;
        }
    }

    public static LinkedListNode returnKToLast(LinkedListNode head, Index index, int k) {
        if (head == null) {
            return null;
        }
        LinkedListNode node = returnKToLast(head.next, index, k);
        index.index++;
        if (index.index == k) {
            return head;
        }
        return node;
    }

    public static void main(String[] args) {
        LinkedListNode n1 = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(returnKToLast(n1, new Index(), 2).data);
    }
}
