package com.algorithm.practice.bst;

import com.algorithm.practice.tree.Node;

public class Floor {
    public static int floor(Node node, int input, int floor) {
        if (node == null) {
            return floor;
        }
        if (node.data == input) {
            return node.data;
        }
        if (node.data > input) {
            return floor(node.left, input, floor);
        } else {
            floor = node.data;
            return floor(node.right, input, floor);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);

        System.out.println(floor(root, 9,  Integer.MIN_VALUE));
    }
}
