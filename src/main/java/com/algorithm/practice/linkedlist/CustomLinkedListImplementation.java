package com.algorithm.practice.linkedlist;

public class CustomLinkedListImplementation {
    static Node head;
    static int size;

    public CustomLinkedListImplementation() {
        this.size = 0;
    }

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void addFirst(int data) {
        size++;
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        node.next = head;
        head = node;
    }

    public static void addLast(int data) {
        size++;
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
    }

    public static void print() {
        if (head == null) {
            System.out.println("List is empty!!");
        }
        Node currentNode = head;
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
        Node lastNode = head.next;
        Node secondLastNode = head;
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
        Node lastNode = head.next;
        Node secondLastNode = head;
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

    public static Node reverseListIterative() {
        if (head == null || head.next == null) {
            return head;
        }
        Node current = head;
        Node previous = null;
        while (current != null) {
            Node next = current.next;
            current.next = previous;

            previous = current;
            current = next;

        }
        head = previous;
        return head;
    }

    public static Node reverseFromRandom(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node current = head;
        Node previous = null;
        while (current != null) {
            Node next = current.next;
            current.next = previous;

            previous = current;
            current = next;

        }
        head = previous;
        return head;
    }

    public static Node reverseRecursive(Node head) {
        if(head==null || head.next==null){
           return head;
        }
      Node newHead =  reverseRecursive(head.next);
      head.next.next = head;
      head.next = null;
      return newHead;
    }

    public static Node deleteNthNodeFromLast(Node head, int n){
        // We consider here n is always valid
        if(head==null && head.next==null){
            return null;
        }
        Node currentNode = head;
        int size=0;
        while(currentNode!=null){
            size++;
            currentNode = currentNode.next;
        }
        int searchIndex = size-n;
        int i=1;
        Node previousNode = head;
        while(i<searchIndex){
            i++;
            previousNode= previousNode.next;
        }
        previousNode.next = previousNode.next.next;
        return head;
    }

    public static Node findMiddle(){
        Node slow = head;
        Node fast = head;
        // Hare-Tortoise Algo to find middle
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean checkForPalindrome(){
        Node middle = findMiddle();
        Node secondHead = reverseFromRandom(middle.next);

        Node firstPointer = head;
        Node secondPointer = secondHead;
        while(secondPointer!=null){
            if(firstPointer.data!=secondPointer.data){
                return false;
            }
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }
        return true;
    }

    public static boolean detectLoop(){
        Node fast = head;
        Node slow = head;

        if(head==null){
            return false;
        }

        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
       head = new Node(1);
       Node n2 = new Node(2);
       Node n3 = new Node(3);
       Node n4 = new Node(4);
       head.next = n2;
       n2.next = n3;
       n3.next = n4;
       n4.next = n2;
        System.out.println(detectLoop());
    }
}
