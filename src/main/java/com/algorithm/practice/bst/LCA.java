package com.algorithm.practice.bst;

import com.algorithm.practice.tree.Node;

public class LCA {

    static Node findLCA(Node node, int first, int second){
        if(node==null){
            return null;
        }
        if(node.data<first && node.data<second){
            return findLCA(node.right, first, second);
        }else if(node.data>first && node.data>second){
            return findLCA(node.left, first, second);
        }else{
            return node;
        }

    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        // Negative test case
        // root.left.left = new Node (17);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);

        System.out.println(findLCA(root, 14, 15).data);
    }
}
