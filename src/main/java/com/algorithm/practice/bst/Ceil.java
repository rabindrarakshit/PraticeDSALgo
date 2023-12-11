package com.algorithm.practice.bst;

import com.algorithm.practice.tree.Node;

public class Ceil {
    public static int ceil(Node node, int input, int ceil) {
        if (node == null) {
            return ceil;
        }
        if (node.data == input) {
            return node.data;
        }
        if (node.data < input) {
            return ceil(node.right, input, ceil);
        } else {
            ceil = node.data;
            return ceil(node.left, input, ceil);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);

        System.out.println(ceil(root, 12,  Integer.MIN_VALUE));
    }
}
