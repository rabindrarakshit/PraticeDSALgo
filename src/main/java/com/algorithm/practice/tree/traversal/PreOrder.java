package com.algorithm.practice.tree.traversal;

import com.algorithm.practice.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrder {
    static void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    static List<Node> iterativePreOrder(Node node) {
        List<Node> preOrder = new ArrayList<>();
        if (node == null) {
            return preOrder;
        }
        Stack<Node> s = new Stack<>();
        s.push(node);
        while (!s.isEmpty()) {
            node = s.pop();
            preOrder.add(node);
            if (node.right != null) {
                s.push(node.right);
            }
            if (node.left != null) {
                s.push(node.left);
            }
        }
        return preOrder;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);


        preOrder(root);
        System.out.println("---------------------------------");
        List<Node> preOrder = iterativePreOrder(root);
        preOrder.forEach(n-> System.out.println(n.data));
    }
}
