package com.algorithm.practice.graph.striver.bfsdfs;

// Ref: https://takeuforward.org/graph/bipartite-graph-dfs-implementation/

import java.util.ArrayList;
import java.util.List;

/*
* Time Complexity: O(V + 2E), Where V = Vertices, 2E is for total degrees as we traverse all adjacent nodes.

Space Complexity: O(3V) ~ O(V), Space for DFS stack space, colour array and an adjacency list.
* */

public class BipartiteGraph {
    static boolean detectBipartiteGraph(List<List<Integer>> list) {
        int vertices = list.size();
        int[] visited = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            visited[i] = -1;
        }
        for (int vertex = 0; vertex < vertices; vertex++) {
            if (visited[vertex] == -1 && !dfs(list, visited, vertex, 0)) {
                return false;
            }
        }
        return true;
    }

    static boolean dfs(List<List<Integer>> list, int[] colours, int vertex, int colour) {
        colours[vertex] = colour;
        for (int it : list.get(vertex)) {
            if (colours[it] == -1) {
                return dfs(list, colours, it, 1 - colour);
            } else {
                if (colours[it] == colour) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // V = 4, E = 4
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        boolean ans = detectBipartiteGraph(adj);
        if (ans)
            System.out.println("1");
        else System.out.println("0");
    }

}
