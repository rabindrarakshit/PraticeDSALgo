package com.ctci.tree.medium;

import com.ctci.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class LeftViewTree {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);
        root.left.left.right = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(3);
        root.right.left = new Node(9);
        root.right.right = new Node(10);
        List<Integer> list = new ArrayList<>();
        getLeftViewTree(root, list, 0);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public static void getLeftViewTree(Node node, List<Integer> list, int depth) {
        if (node == null) {
            return;
        }
        if (depth == list.size()) {
            list.add(node.data);
        }
        getLeftViewTree(node.left, list, depth + 1);
        getLeftViewTree(node.right, list, depth + 1);
    }
}
