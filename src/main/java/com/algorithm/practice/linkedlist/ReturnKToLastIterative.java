package com.algorithm.practice.linkedlist;
import static com.algorithm.practice.linkedlist.util.LinkedListUtil.Node;
public class ReturnKToLastIterative {
    public static Node returnKToLast(Node head, int k){
        Node p1= head;
        Node p2 = head;

        for(int i=0; i<k;i++){
            if(p2==null){
                return null;
            }
            p2=p2.next;
        }
        while(p2!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(returnKToLast(n1,  2).data);
    }
}
