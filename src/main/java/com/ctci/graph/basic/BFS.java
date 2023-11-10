package com.ctci.graph.basic;

import java.util.LinkedList;

public class BFS {
    public static void search(Node node) {
        LinkedList<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node root = q.removeFirst();
            root.visited = true;
            System.out.println(root.value);
            for (Node n : root.adjacent) {
                if (n.visited == false) {
                    n.visited = true;
                    q.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(4);
        Node n3 = new Node(5);
        Node n4 = new Node(2);
        Node n5 = new Node(3);
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
