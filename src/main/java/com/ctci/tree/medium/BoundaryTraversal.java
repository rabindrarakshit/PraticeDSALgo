package com.ctci.tree.medium;

import com.ctci.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        List < Integer > boundaryTraversal;
        boundaryTraversal = printBoundary(root);

        System.out.println("The Boundary Traversal is : ");
        for (int i = 0; i < boundaryTraversal.size(); i++) {
            System.out.print(boundaryTraversal.get(i) + " ");
        }
        printBoundary(root);
    }

    public static List<Integer> printBoundary(Node node) {
        List<Integer> list = new ArrayList<>();
        printLeftBoundary(node, list);
        printLeaves(node, list);
        printRightBoundary(node, list);
        return list;
    }

    public static void printLeaves(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            list.add(node.data);
        }
        if (node.left != null) {
            printLeaves(node.left, list);
        }
        if (node.right != null) {
            printLeaves(node.right, list);
        }
    }

    public static void printLeftBoundary(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (!isLeaf(node)) {
            list.add(node.data);
        }
        if (node.left != null) {
            printLeftBoundary(node.left, list);
        } else {
            printLeftBoundary(node.right, list);
        }
    }

    public static void printRightBoundary(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (!isLeaf(node)) {
            list.add(node.data);
        }
        if (node.right != null) {
            printRightBoundary(node.right, list);
        } else {
            printRightBoundary(node.left, list);
        }
    }

    public static boolean isLeaf(Node node) {
        return node != null && node.left == null && node.right == null;
    }

}
