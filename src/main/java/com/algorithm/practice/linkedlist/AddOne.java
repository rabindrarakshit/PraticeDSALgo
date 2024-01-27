package com.algorithm.practice.linkedlist;

public class AddOne {

    // Naive solution
    // Time: O(3n)
    // Space : if we do not consider the auxiliary space then O(1)
    static LinkedListNode addOne(LinkedListNode head) {
        int count = -1;
        LinkedListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        current = head;
        int num = 0;
        while (count >= 0) {
            num = num + current.data * (int) (Math.pow(10, count));
            count--;
            current = current.next;
        }
        num++;
        LinkedListNode prev = null;
        LinkedListNode node = null;
        while (num > 0) {
            node = new LinkedListNode(num % 10);
            node.next = prev;
            prev = node;
            num = num / 10;
        }
        return node;
    }

    // Another naive solution would be reverse add one to the first node and if there is a carry move it forward. And then
    // reverse again. Time : O(3N) Space : O(1)

    // Optimized Time O(n) Space O(n)->Stack memory
    static int addOneRecursive(LinkedListNode head){
        if(head==null){
            return 1;
        }
        int carry = addOneRecursive(head.next);
        head.data = head.data+carry;
        if(head.data>9){
            head.data%=10;
            return 1;
        }
        return carry;
    }

    static LinkedListNode addOneR(LinkedListNode head){
        int carry = addOneRecursive(head);
        LinkedListNode node = null;
        if(carry ==1){
            node = new LinkedListNode(1);
            node.next = head;
        }
        return node;
    }

    public static void main(String[] args) {
        LinkedListUtil.printLinkedList(addOne(ConvertArrayToLinkedList.convert(new int[]{9, 9, 9})));
        System.out.println();
        LinkedListUtil.printLinkedList(addOneR(ConvertArrayToLinkedList.convert(new int[]{9, 9, 9})));
    }
}
