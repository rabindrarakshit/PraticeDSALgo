package com.algorithm.practice.tree.medium;

import java.util.LinkedList;

public class TryTraversingTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static void preOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.data +" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    static void postOrderTraversal(TreeNode root){
        if(root==null)
            return;
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data);
    }

    static void inOrderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data);
        inOrderTraversal(root.right);
    }

    static void bfs(TreeNode root){
        if(root==null)
            return;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode current = q.removeFirst();
            if(current!=null){
                System.out.print(current.data);
                q.add(current.left);
                q.add(current.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;

        System.out.println("Pre Order:");
        preOrderTraversal(node1);

        System.out.println("\n"+"Post Order:");
        postOrderTraversal(node1);

        System.out.println("\n"+"In Order:");
        inOrderTraversal(node1);

        System.out.println("\n"+"BFS:");
        bfs(node1);

    }
}
