package com.algorithm.practice.graph.striver.basic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Ref: https://takeuforward.org/graph/breadth-first-search-bfs-level-order-traversal/
// Time: O(Vertices+ 2*Edges)
// Degree of a undirected graph = 2*Edges

public class BFS {
    static List<Integer> bfs(List<List<Integer>> adjList) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> bfs = new ArrayList<>();
        int size = adjList.size();
        boolean[] visited = new boolean[size + 1];

        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);
            for (Integer i : adjList.get(node)) {
                if (!visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            list.add(new ArrayList<>());
        }
        list.get(0).add(1);
        list.get(0).add(2);

        list.get(1).add(2);
        list.get(1).add(0);

        list.get(2).add(1);
        list.get(2).add(0);

        boolean[] visited = new boolean[3];
        List<Integer> res = new ArrayList<>();
        res = bfs(list);
        for (int i : res)
            System.out.println(i);
    }
}
