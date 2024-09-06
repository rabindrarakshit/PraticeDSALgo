package com.algorithm.practice.tree.traversal;

import com.algorithm.practice.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Refer: https://takeuforward.org/data-structure/post-order-traversal-of-binary-tree/

public class PostOrder {
    static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data);
    }

    static List<Node> iterativePostOrder1Stack(Node node) {

        Stack<Node> stack = new Stack<>();
        List<Node> postOrder = new ArrayList<>();
        if (node == null) return postOrder;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                Node temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    postOrder.add(temp);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        postOrder.add(temp);
                    }
                } else {
                    node = temp;
                }
            }
        }
        return postOrder;
    }

    static List<Node> iterativePostOrder2Stack(Node node) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        List<Node> postOrder = new ArrayList<>();

        stack1.push(node);

        while (!stack1.isEmpty()) {
            node = stack1.pop();
            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
            stack2.push(node);
        }
        while (!stack2.isEmpty()) {
            postOrder.add(stack2.pop());
        }
        return postOrder;
    }


    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);

        postOrder(root);
        System.out.println("---------------------------");
        iterativePostOrder1Stack(root).forEach(n -> System.out.println(n.data));
        System.out.println("---------------------------");
        iterativePostOrder2Stack(root).forEach(n -> System.out.println(n.data));
    }
}
