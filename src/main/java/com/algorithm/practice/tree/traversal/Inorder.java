package com.algorithm.practice.tree.traversal;

import com.algorithm.practice.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Ref: https://takeuforward.org/data-structure/inorder-traversal-of-binary-tree/

public class Inorder {
    public static List<Integer> inOrder(Node root) {
        List<Integer> arr = new ArrayList<>();
        inOrder(root, arr);
        return arr;
    }
    static void inOrder(Node node, List<Integer> list) {
        if(node==null)
            return;
        inOrder(node.left, list);
        list.add(node.data);
        inOrder(node.right, list);
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

        inOrder(root).forEach(n -> System.out.print(n+" "));
        System.out.println("----");
        iterativeInOrder(root).forEach(n -> System.out.print(n.data+" "));
    }
}
