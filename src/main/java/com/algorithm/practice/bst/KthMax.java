package com.algorithm.practice.bst;

import com.algorithm.practice.tree.Node;

public class KthMax {

    static int count = 0;
    public static Node max(Node root, int k) {
        if (root == null) {
            return null;
        }
        Node right = max(root.right, k);
        if (right != null) {
            return right;
        }
        count++;
        if (count == k) {
            return root;
        }
        return max(root.left, k);
    }

    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);

        System.out.println(max(root,  3).data);
    }
}
