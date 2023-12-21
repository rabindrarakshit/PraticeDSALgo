package com.algorithm.practice.bst;

import com.algorithm.practice.tree.Node;

public class CheckBST {

    static boolean isValidBst(Node root){
        return isValidBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean isValidBst(Node root, long min, long max){
        if(root==null){
            return true;
        }
        if(root.data<=min || root.data>=max){return false;}
        return isValidBst(root.left, min, root.data) && isValidBst(root.right, root.data, max);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        // Negative test case
        // root.left.left = new Node (17);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);

        System.out.println(isValidBst(root));
    }
}
