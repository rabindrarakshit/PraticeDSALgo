package com.algorithm.practice.bst;

/*
 * Problem: https://leetcode.com/problems/recover-binary-search-tree/
 *
 * Brute: Any Traversal + Sort + Inorder(During inOrder check with the sorted data for the inconsistent points.
 * If there is a mismatch then replace the tree with the value from the sorted list)
 *
 * Time Complexity: O(n)+ O(nlog(n))+O(n)
 * Space Complexity: O(n)
 *
 * Optimized:
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) -> We don't consider the recursion stack memory here.
 * */

import com.algorithm.practice.tree.Node;

public class RepairBST {

    private static Node prev, first, middle, last;

    static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        if (prev != null && node.data < prev.data) {
            if (first == null) {
                first = prev;
                middle = node;
            } else {
                last = node;
            }
        }
        prev = node;
        inOrder(node.right);
    }

    static void repairBST(Node node){
        inOrder(node);
        if(first!=null && last!=null){
            swap(first, last);
        }else if(first!=null && middle!=null){
            swap(first, middle);
        }
    }

    static void swap(Node first, Node second){
        int temp = first.data;
        first.data = second.data;
        second.data = temp;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(13);

        root.right.left = new Node(14);
        root.right.right = new Node(15);

        // we need to swap 13 and 14 here
        prev = new Node(Integer.MIN_VALUE);
        repairBST(root);

        System.out.println(root.data);
    }
}
