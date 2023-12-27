package com.algorithm.practice.tree.traversal;

import com.algorithm.practice.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Inorder {
    static List<Integer> result = new ArrayList<>();

    static List<Integer> inOrder(Node node) {
        if (node.left != null)
            inOrder(node.left);
        result.add(node.data);
        if (node.right != null) {
            inOrder(node.right);
        }
        return result;
    }

    static List<Node> iterativeInOrder(Node node) {
        Stack<Node> s = new Stack<>();
        List<Node> list = new ArrayList<>();
        while (true) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                if (s.isEmpty()) {
                    break;
                }
                node = s.pop();
                list.add(node);
                node = node.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);

        iterativeInOrder(root).forEach(n -> System.out.println(n.data));
    }
}
