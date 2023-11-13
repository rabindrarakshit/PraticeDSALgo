package com.ctci.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class LevelNode {
    Node node;
    int level;

    public LevelNode(Node node, int level) {
        this.node = node;
        this.level = level;
    }
}

public class TopViewTree {
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

        topDownView(root);
    }

    public static void topDownView(Node root) {
        Queue<LevelNode> q = new LinkedList<>();
        q.offer(new LevelNode(root, 0));
        Map<Integer,Integer> map = new TreeMap<>();
        while(!q.isEmpty()){
            LevelNode levelNode = q.poll();
            Node node = levelNode.node;
            int level = levelNode.level;
            map.computeIfAbsent(level, k -> node.data);
            if(node.left!=null){
                q.offer(new LevelNode(node.left, level-1));
            }
            if(node.right!=null){
                q.offer(new LevelNode(node.right, level+1));
            }
        }
        for(Integer i: map.values()){
            System.out.print(i+ " ");
        }
    }
}
