package com.ctci.linkedlist;

import static com.ctci.linkedlist.util.LinkedListUtil.Node;

public class ReturnKToLastRecursive {

    static class Index {
        int index;

        Index() {
            this.index = 0;
        }
    }

    public static Node returnKToLast(Node head, Index index, int k) {
        if (head == null) {
            return null;
        }
        Node node = returnKToLast(head.next, index, k);
        index.index++;
        if (index.index == k) {
            return head;
        }
        return node;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(returnKToLast(n1, new Index(), 2).data);
    }
}
