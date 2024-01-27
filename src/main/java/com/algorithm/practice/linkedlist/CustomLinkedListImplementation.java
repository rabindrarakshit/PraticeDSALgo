package com.algorithm.practice.linkedlist;

public class CustomLinkedListImplementation {
    static LinkedListNode head;
    static int size;

    public CustomLinkedListImplementation() {
        this.size = 0;
    }



    public static void addFirst(int data) {
        size++;
        LinkedListNode node = new LinkedListNode(data);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public static void addLast(int data) {
        size++;
        LinkedListNode node = new LinkedListNode(data);
        if (head == null) {
            head = node;
            return;
        }
        LinkedListNode currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
    }

    public static void print() {
        if (head == null) {
            System.out.println("List is empty!!");
        }
        LinkedListNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static void removeFirst() {
        if (head == null) {
            System.out.println("List is empty!!");
        }
        size--;
        head = head.next;
    }

    public static void removeLast() {
        if (head == null) {
            System.out.println("List is empty!!");
        }
        size--;
        if (head.next == null) {
            head = null;
            return;
        }
        LinkedListNode lastNode = head.next;
        LinkedListNode secondLastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
            secondLastNode = secondLastNode.next;
        }
        secondLastNode.next = null;
    }

    public static void removeIndex(int index) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (index == 0) {
            if (head.next != null) {
                size--;
                head = head.next;
                return;
            }
            head = null;
        }
        int i = 1;
        LinkedListNode lastNode = head.next;
        LinkedListNode secondLastNode = head;
        while (lastNode != null) {
            if (i == index) {
                size--;
                secondLastNode.next = lastNode.next;
                return;
            }
            lastNode = lastNode.next;
            secondLastNode = secondLastNode.next;
            i++;
        }
        System.out.println("No elements at the provided index!");
    }


    public static LinkedListNode reverseFromRandom(LinkedListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedListNode current = head;
        LinkedListNode previous = null;
        while (current != null) {
            LinkedListNode next = current.next;
            current.next = previous;

            previous = current;
            current = next;

        }
        head = previous;
        return head;
    }


    public static void main(String[] args) {
        head = new LinkedListNode(1);
        LinkedListNode n2 = new LinkedListNode(2);
        LinkedListNode n3 = new LinkedListNode(3);
        LinkedListNode n4 = new LinkedListNode(4);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
    }
}
