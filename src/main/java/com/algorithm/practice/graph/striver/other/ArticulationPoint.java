package com.algorithm.practice.graph.striver.other;

// Ref: https://takeuforward.org/data-structure/articulation-point-in-graph-g-56/

import java.util.ArrayList;
import java.util.List;

/*
* Time Complexity: O(V+2E), where V = no. of vertices, E = no. of edges. It is because the algorithm is just a simple DFS traversal.

Space Complexity: O(3V), where V = no. of vertices. O(3V) is for the three arrays i.e. tin, low, and vis, each of size V.
*
* */

public class ArticulationPoint {
    static List<Integer> articulationPoints(int[][] edges, int nodes) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
            adjList.get(edges[i][1]).add(edges[i][0]);
        }

        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[nodes];
        int[] tin = new int[nodes];
        int[] low = new int[nodes];
        dfs(adjList, 0, -1, result, visited, tin, low);
        return result;
    }

    static int counter = 1;

    static void dfs(List<List<Integer>> adjList, int node, int parent, List<Integer> result, boolean[] visited,
                    int[] tin, int[] low) {
        tin[node] = low[node] = counter++;
        visited[node] = true;
        for (Integer adjNode : adjList.get(node)) {
            if (adjNode == parent) continue;
            if (!visited[adjNode]) {
                dfs(adjList, adjNode, node, result, visited, tin, low);
                low[node] = Math.min(low[adjNode], low[node]);
                if (low[adjNode] >= tin[node] && parent != -1) {
                    result.add(node);
                }
            } else {
                low[node] = Math.min(low[adjNode], low[node]);
            }
        }
        if (parent == -1 && adjList.get(node).size() > 1) {
            result.add(node);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1}, {1, 4},
                {2, 4}, {2, 3}, {3, 4}
        };

        for (Integer i : articulationPoints(edges, n)) {
            System.out.print(i + " ");
        }
    }
}
