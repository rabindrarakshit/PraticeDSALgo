package com.ctci.tree.hard;

import com.ctci.tree.Node;

public class LowestCommonAncestor {
    public static Node findLCA(Node node, Integer num1, Integer num2) {
        if (node == null || node.data == num1 || node.data == num2) {
            return node;
        }
        Node left = findLCA(node.left, num1, num2);
        Node right = findLCA(node.right, num1, num2);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return node;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(12);
        root.right = new Node(13);

        root.right.left = new Node(14);
        root.right.right = new Node(15);

        root.right.left.left = new Node(21);
        root.right.left.right = new Node(22);
        root.right.right.left = new Node(23);
        root.right.right.right = new Node(24);

        System.out.println(findLCA(root, 23, 24).data);
    }
}
