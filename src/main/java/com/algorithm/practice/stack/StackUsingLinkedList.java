package com.algorithm.practice.stack;

public class StackUsingLinkedList {
    static class Node<K>{
        Node next;
        K data;

        Node(K data){
            this.data = data;
            this.next = null;
        }
    }
    public static class Stack<K>{
        Node head;

        public boolean isEmpty(){
            return head ==null? true : false;
        }

        public void push(K data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public void pushAtBottom(K data){
            if(head==null){
                Node node = new Node(data);
                head = node;
                return;
            }
            K top = pop();
            pushAtBottom(data);
            push(top);
        }

        public K peek(){
            if(isEmpty()){
                return null;
            }
            return (K) head.data;
        }

        public K pop(){
            if(isEmpty()){
                return null;
            }
            K data = (K) head.data;
            head = head.next;
            return data;
        }

        public void reverse(){
            if(head.next==null){
                return;
            }
            K top = pop();
            reverse();
            pushAtBottom(top);
        }
    }

    public static void main(String[] args){
        Node node1 = new Node(2);
        Node node2 = new Node(3);

        Stack stack = new Stack();
        stack.head = node1;
        node1.next = node2;

        stack.pushAtBottom(1);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
    }
}
