package com.algorithm.practice.bst;

import com.algorithm.practice.tree.Node;

public class MinBST {
    public static int min(Node node, int min) {
        if (node == null) {
            return min;
        }
        min = Math.min(min, node.data);
        return min(node.left, min);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);

        System.out.println(min(root, Integer.MAX_VALUE));
    }
}
