package com.ctci.tree.hard;

import com.ctci.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(12);
        root.right = new Node(13);

        root.right.left = new Node(14);
        root.right.right = new Node(15);

        root.right.left.left = new Node(21);
        root.right.left.right = new Node(22);
        root.right.right.left = new Node(23);
        root.right.right.right = new Node(24);

        List<Integer> list = new ArrayList<>();
        findRoute(root, 24, list);
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public static boolean findRoute(Node node, int data, List<Integer> list) {
        if (node == null)
            return false;
        list.add(node.data);
        if (node.data == data) {
            return true;
        }
        if (findRoute(node.left, data, list) || findRoute(node.right, data, list)) {
            return true;
        }
        list.remove(list.size() - 1);
        return false;
    }
}
