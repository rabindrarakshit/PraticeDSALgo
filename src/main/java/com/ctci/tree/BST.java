package com.ctci.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST {

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static int getHeight(Node root) {
        int height = -1;
        int nodeSize = 0;
        Queue q = new LinkedList<Integer>();
        q.add(root);
        while (true) {
            nodeSize = q.size();
            if (nodeSize == 0) {
                return height;
            } else {
                height++;
            }
            while (nodeSize > 0) {
                Node node = (Node) q.remove();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                nodeSize--;
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        Node root = null;
        while (T-- > 0) {
            int data = sc.nextInt();
            root = insert(root, data);
        }
        int height = getHeight(root);
        System.out.println(height);
    }
}
