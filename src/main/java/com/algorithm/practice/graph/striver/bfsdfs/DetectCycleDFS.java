package com.algorithm.practice.graph.striver.bfsdfs;

import java.util.ArrayList;
import java.util.List;

// Ref: https://takeuforward.org/data-structure/detect-cycle-in-an-undirected-graph-using-dfs/
// Time : O(N + 2E) | Space : O(N)--> visited + O(N) --> stack space

public class DetectCycleDFS {
    static boolean detectCycleDFS(List<List<Integer>> list) {
        boolean[] visited = new boolean[list.size()];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                if (dfs(list, visited, -1, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean dfs(List<List<Integer>> list, boolean[] visited, int parent, int node) {
        visited[node] = true;
        List<Integer> adjNodes = list.get(node);
        for (Integer adjNode : adjNodes) {
            if (!visited[adjNode]) {
                if (dfs(list, visited, node, adjNode)) {
                    return true;
                }
            } else {
                if (parent != adjNode) {
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
        //  adj.get(3).add(1);
        //  adj.get(1).add(3);


        System.out.println(detectCycleDFS(adj));
    }
}
