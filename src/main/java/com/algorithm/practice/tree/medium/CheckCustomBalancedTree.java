package com.algorithm.practice.tree.medium;

import com.algorithm.practice.tree.Node;

public class CheckCustomBalancedTree {
    public static int checkBalancedTree(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = checkBalancedTree(root.left);
        if (leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = checkBalancedTree(root.right);
        if (rightHeight == Integer.MIN_VALUE) {
            return rightHeight;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(leftHeight, rightHeight) + 1;

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;
        if (Integer.MIN_VALUE == checkBalancedTree(node1)) {
            System.out.println("Not Balanced");
        } else {
            System.out.println("Balanced");
        }
    }
}
