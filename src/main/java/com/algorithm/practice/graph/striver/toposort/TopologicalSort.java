package com.algorithm.practice.graph.striver.toposort;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Ref: https://takeuforward.org/data-structure/topological-sort-algorithm-dfs-g-21/
// Time: O(V+2E)
// Space: O(3V) Stack+Visited Array+Recursive Stack Space
public class TopologicalSort {
    static Stack<Integer> getTopoSort(List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                dfs(adjList, s, visited, i);
            }
        }
        return s;
    }

    static void dfs(List<List<Integer>> adjList, Stack<Integer> stack, boolean[] visited, int node) {
        visited[node] = true;
        List<Integer> adjNodes = adjList.get(node);
        for (int adjNode : adjNodes) {
            if (!visited[adjNode]) {
                dfs(adjList, stack, visited, adjNode);
            }
        }
        stack.push(node);
    }

    public static void main(String[] args) {
        int V = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        Stack<Integer> s = getTopoSort(adj);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
