package com.algorithm.practice.bst;

import com.algorithm.practice.tree.Node;

public class MaxBST {
    public static int max(Node node, int max) {
        if (node == null) {
            return max;
        }
        max = Math.max(max, node.data);
        return max(node.right, max);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);

        System.out.println(max(root, Integer.MIN_VALUE));
    }
}
