package com.algorithm.practice.linkedlist;

public class ConvertArrayToDoubleLinkedList {
    static DoubleLinkedListNode convert(int[] arr){
        DoubleLinkedListNode head = new DoubleLinkedListNode(arr[0]);
        DoubleLinkedListNode prev = head;
        for(int i=1;i<arr.length;i++){
            DoubleLinkedListNode current = new DoubleLinkedListNode(arr[i], prev, null);
            prev.next = current;
            prev = current;
        }
        return head;
    }

    public static void main(String[] args) {
        DoubleLinkedListNode head = convert(new int[]{1,2,3,4});
        DoubleLinkedListInsertion.printDoubleLinkedList(head);
    }
}
