package com.algorithm.practice.graph.basic;

public class DFS {
    public static void search(Node root) {
        if (root == null) {
            return;
        }
        root.visited = true;
        System.out.println(root.value);
        for (Node n : root.adjacent) {
            if (n.visited == false) {
                search(n);
            }
        }
    }


    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.adjacent.add(n2);
        n1.adjacent.add(n3);
        n2.adjacent.add(n4);
        n2.adjacent.add(n5);
        n3.adjacent.add(n6);
        n3.adjacent.add(n7);
        search(n1);
    }
}