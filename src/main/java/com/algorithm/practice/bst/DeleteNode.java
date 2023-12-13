package com.algorithm.practice.bst;

import com.algorithm.practice.tree.Node;

public class DeleteNode {
    public static Node delete(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (node.data > data) {
            node.left = delete(node.left, data);
        } else if (node.data < data) {
            node.right = delete(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }

            Node leastRight = node.right;
            while (leastRight.left != null) {
                leastRight = leastRight.left;
            }
            leastRight.left = node.left;
            return node.right;
        }
        return node;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);
        delete(root, 17);
        System.out.println(root.data);
    }
}
