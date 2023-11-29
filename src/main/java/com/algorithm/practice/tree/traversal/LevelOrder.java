package com.algorithm.practice.tree.traversal;

import com.algorithm.practice.tree.Node;

import java.util.LinkedList;

public class LevelOrder {
    public static int heightOfTree(Node root) {
        if (root == null) {
            return 0;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Node remNode = queue.removeFirst();
                if (remNode.left != null) {
                    queue.addLast(remNode.left);
                }
                if (remNode.right != null) {
                    queue.addLast(remNode.right);
                }
            }
            level++;
        }
        return level;
    }

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

        System.out.println("Height(Depth) of tree is: " + heightOfTree(root));
    }
}
