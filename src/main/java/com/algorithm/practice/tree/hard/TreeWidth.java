package com.algorithm.practice.tree.hard;

import com.algorithm.practice.tree.Node;

import java.util.LinkedList;
import java.util.Queue;

class Pair {
    Node node;
    int num;

    Pair(Node node, int num) {
        this.node = node;
        this.num = num;
    }
}

public class TreeWidth {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(12);
        root.right = new Node(13);

        root.left.left = new Node(25);

        root.right.left = new Node(14);
        root.right.right = new Node(15);

        root.right.left.left = new Node(21);
        root.right.left.right = new Node(22);
        root.right.right.left = new Node(23);
        root.right.right.right = new Node(24);

        root.left.left.left = new Node(26);

        System.out.println(findMaxWidth(root));

    }
    public static Integer findMaxWidth(Node root) {
        Pair rootP = new Pair(root, 0);
        Queue<Pair> q = new LinkedList<>();
        q.offer(rootP);
        int width = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            int start = 0;
            int end = 0;
            Integer mMin = q.peek().num;
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    start = q.peek().num;
                }
                if (i == size - 1) {
                    end = q.peek().num;
                }
                Pair p = q.poll();
                Node node = p.node;
                if (node.left != null) {
                    q.offer(new Pair(node.left, p.num * 2));
                }
                if (node.right != null) {
                    q.offer(new Pair(node.right, p.num * 2 + 1));
                }
            }
            width = Math.max(width, end - start + 1);
        }
        return width;
    }

}
