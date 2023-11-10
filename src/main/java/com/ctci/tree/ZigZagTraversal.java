package com.ctci.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversal {
    public static void main(String[] args) {
        int i, j;
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        ArrayList < ArrayList < Node >> ans;
        ans = zigZagTraverse(root);
        System.out.println("Zig Zag Traversal of Binary Tree ");
        for (i = 0; i < ans.size(); i++) {
            for (j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j).data + " ");
            }
            System.out.println();
        }

    }

    public static ArrayList<ArrayList<Node>> zigZagTraverse(Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        ArrayList<ArrayList<Node>> wrapList = new ArrayList<>();
        boolean flag = true;
        ArrayList<Node> subList = null;
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                if (flag) {
                    subList.add(queue.poll());
                } else {
                    subList.add(0, queue.poll());
                }
            }
            flag = !flag;
            wrapList.add(subList);
        }
        return wrapList;
    }

    public static ArrayList < ArrayList < Integer >> zigzagLevelOrder(Node root) {
        Queue< Node > queue = new LinkedList < Node > ();
        ArrayList < ArrayList < Integer >> wrapList = new ArrayList < > ();

        if (root == null) return wrapList;

        queue.offer(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            ArrayList < Integer > subList = new ArrayList < Integer > (levelNum);
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) queue.offer(queue.peek().left);
                if (queue.peek().right != null) queue.offer(queue.peek().right);
                if (flag == true) subList.add(queue.poll().data);
                else subList.add(0, queue.poll().data);
            }
            flag = !flag;
            wrapList.add(subList);
        }
        return wrapList;
    }

}
