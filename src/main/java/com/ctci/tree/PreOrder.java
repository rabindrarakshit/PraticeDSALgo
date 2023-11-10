package com.ctci.tree;

public class PreOrder {
    static void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }


    public static void main(String[] args) {
        Node node = new Node(3);
        Node left = new Node(1);
        Node right = new Node(2);
        node.left = left;
        node.right = right;
        preOrder(node);
    }
}
