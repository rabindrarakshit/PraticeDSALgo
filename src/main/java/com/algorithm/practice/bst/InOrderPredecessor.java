package com.algorithm.practice.bst;

import com.algorithm.practice.tree.Node;

public class InOrderPredecessor {

    // recursive
    static int inOrderPredecessor(Node node, int data, int predecessor) {
        if (node == null) {
            return predecessor;
        }
        if (node.data < data) {
            return inOrderPredecessor(node.right, data, node.data);
        } else {
            return inOrderPredecessor(node.left, data, predecessor);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);

        System.out.println(inOrderPredecessor(root, 13,  Integer.MIN_VALUE));
    }
}
