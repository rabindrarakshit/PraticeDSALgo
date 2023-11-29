package com.algorithm.practice.tree.traversal;

import com.algorithm.practice.tree.Node;

public class PostOrder {
    static void postOrder(Node node){
        if(node!=null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

    public static void main(String[] args) {
        Node node = new Node(3);
        Node left = new Node(1);
        Node right = new Node(2);
        node.left = left;
        node.right = right;
        postOrder(node);
    }
}
