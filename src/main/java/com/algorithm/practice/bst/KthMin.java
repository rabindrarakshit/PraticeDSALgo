package com.algorithm.practice.bst;

import com.algorithm.practice.tree.Node;

public class KthMin {

    static int count;
    public static Node min(Node node, int k){
        if(node==null){
            return null;
        }
        Node left = min(node.left, k);
        if(left!=null){
            return left;
        }
        count++;
        if(count==k){
            return node;
        }
        return min(node.right, k);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);

        System.out.println(min(root,  3).data);
    }
}
