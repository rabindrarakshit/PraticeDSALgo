package com.algorithm.practice.graph.striver.other;

// Ref: https://takeuforward.org/graph/bridges-in-graph-using-tarjans-algorithm-of-time-in-and-low-time-g-55/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Time Complexity: O(V+2E), where V = no. of vertices, E = no. of edges. It is because the algorithm is just a simple DFS traversal.

Space Complexity: O(V+2E) + O(3V), where V = no. of vertices, E = no. of edges. O(V+2E) to store the graph in an adjacency
* list and O(3V) for the three arrays i.e. tin, low, and vis, each of size V.

*
* */

public class TarjansAlgo {
    static List<List<Integer>> calculateBridges(int[][] graph, int nodes) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            adjList.get(graph[i][0]).add(graph[i][1]);
        }
        int[] visited = new int[nodes];
        int[] tin = new int[nodes];
        int[] minIn = new int[nodes];
        List<List<Integer>> bridges = new ArrayList<>();
        return dfs(adjList, 0, -1, visited, tin, minIn, bridges);
    }

    static int counter = 1;

    static List<List<Integer>> dfs(List<List<Integer>> adj, int node, int parent, int[] visited, int[] tin, int[] low,
                                   List<List<Integer>> bridges) {
        visited[node] = 1;
        tin[node] = low[node] = counter;
        counter++;
        for (Integer adjNode : adj.get(node)) {
            if (adjNode == parent) continue;
            if (visited[adjNode] == 0) {
                dfs(adj, adjNode, node, visited, tin, low, bridges);
                low[node] = Math.min(low[node], low[adjNode]);
                // node --- it
                if (low[adjNode] > tin[node]) {
                    bridges.add(Arrays.asList(adjNode, node));
                }
            } else {
                low[node] = Math.min(low[node], low[adjNode]);
            }
        }
        return bridges;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1}, {1, 4},
                {2, 4}, {2, 3}, {3, 4}
        };
    }
}
