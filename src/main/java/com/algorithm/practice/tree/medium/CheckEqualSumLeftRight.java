package com.algorithm.practice.tree.medium;

import com.algorithm.practice.tree.Node;

public class CheckEqualSumLeftRight {
    static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        return sum(node.left) + node.data + sum(node.right);
    }

    static int isSumEqual(Node node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 1;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);

        if ((leftSum+ rightSum == node.data) && (isSumEqual(node.left) == 1) && (isSumEqual(node.right) == 1)) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);
        if (isSumEqual(root) != 0) {
            System.out.println("The given tree is a SumTree");
        } else {
            System.out.println("The given tree is not a SumTree");
        }
    }
}
