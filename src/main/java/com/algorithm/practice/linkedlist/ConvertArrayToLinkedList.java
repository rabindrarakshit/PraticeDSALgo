package com.algorithm.practice.linkedlist;

public class ConvertArrayToLinkedList {
    static LinkedListNode convert(int[] arr){
        LinkedListNode head = new LinkedListNode(arr[0]);
        LinkedListNode prev = head;
        for(int i=1;i<arr.length;i++){
            LinkedListNode current = new LinkedListNode(arr[i]);
            prev.next = current;
            prev = current;
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedListNode head = convert(new int[]{1,2,3,4});
        LinkedListUtil.printLinkedList(head);
    }
}
