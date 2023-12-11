package com.algorithm.practice.bst;

import com.algorithm.practice.tree.Node;

public class Search {
    public static boolean search(Node node, int data) {
        if (node == null) {
            return false;
        }
        if (node.data == data) {
            return true;
        }
        if (node.data < data) {
            return search(node.right, data);
        } else {
            return search(node.left, data);
        }
    }

    public static void main(String[] args) {
        Node root  = new Node(10);
        root.left  = new Node(9);
        root.right = new Node(14);

        root.right.left   = new Node(13);
        root.right.right  = new Node(15);

        System.out.println(search(root, 13));
        System.out.println(search(root, 17));
    }
}
