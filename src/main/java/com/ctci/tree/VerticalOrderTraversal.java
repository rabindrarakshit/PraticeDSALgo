package com.ctci.tree;

import java.util.*;

class Tuple {
    Node node;
    Integer row;
    Integer col;

    public Tuple(Node node, Integer row, Integer col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

public class VerticalOrderTraversal {
    public static List<Integer> findVerticalOrderTraversal(Node n) {
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(n, 0, 0));
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            Node node = tuple.node;
            map.computeIfAbsent(tuple.col, k -> new TreeMap<>());
            map.get(tuple.col).computeIfAbsent(tuple.row, k -> new PriorityQueue<>());
            map.get(tuple.col).get(tuple.row).offer(tuple.node.data);
            if (node.left != null) {
                queue.offer(new Tuple(node.left, tuple.row + 1, tuple.col - 1));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, tuple.row + 1, tuple.col + 1));
            }
        }
        List<Integer> list = new ArrayList<>();
        for (Map<Integer, PriorityQueue<Integer>> m : map.values()) {
            for (PriorityQueue<Integer> q : m.values()) {
                while (!q.isEmpty()) {
                    list.add(q.poll());
                }
            }
        }
        return list;
    }

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

        for (Integer i : findVerticalOrderTraversal(root)) {
            System.out.println(i);
        }
    }
}
