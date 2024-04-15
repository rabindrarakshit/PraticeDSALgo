package com.algorithm.practice.graph.striver.bfsdfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Ref: https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-bfs/

public class DetectCycleBFS {
    static class Pair {
        int node;
        int parent;

        public Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    static boolean detectCycleBFS(List<List<Integer>> adjList, int start, boolean[] visited) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, -1));
        visited[start] = true;

        while (!q.isEmpty()) {
            Pair p = q.poll();
            List<Integer> adjNodes = adjList.get(p.node);
            for (Integer adjNode : adjNodes) {
                if (!visited[adjNode]) {
                    q.add(new Pair(adjNode, p.node));
                    visited[adjNode] = true;
                } else {
                    if (adjNode != p.parent) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    static boolean isCycle(List<List<Integer>> adjList, int start) {
        boolean[] visited = new boolean[adjList.size() + 1];
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                if (detectCycleBFS(adjList, start, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(1);
        adj.get(1).add(3);


        System.out.println(isCycle(adj, 1));
    }
}
