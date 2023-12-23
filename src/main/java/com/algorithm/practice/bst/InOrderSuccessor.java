package com.algorithm.practice.bst;

import com.algorithm.practice.tree.Node;

public class InOrderSuccessor {

    // recursive
    static int inOrderSuccessor(Node node, int data, int successor) {
        if (node == null) {
            return successor;
        }
        if (node.data < data) {
            return inOrderSuccessor(node.right, data, successor);
        } else {
            return inOrderSuccessor(node.left, data, node.data);
        }
    }

    // iterative
    static int inOrderSuccessor(Node node, int data) {
        int successor = Integer.MIN_VALUE;
        while (node != null) {
            if (node.data > data) {
                successor = node.data;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return successor;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);

        System.out.println(inOrderSuccessor(root, 12,  Integer.MIN_VALUE));
        System.out.println(inOrderSuccessor(root, 12));
    }
}
