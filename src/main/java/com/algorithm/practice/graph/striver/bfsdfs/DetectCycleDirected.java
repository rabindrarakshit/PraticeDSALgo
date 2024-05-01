package com.algorithm.practice.graph.striver.bfsdfs;

import java.util.ArrayList;
import java.util.List;

//Ref: https://takeuforward.org/data-structure/detect-cycle-in-a-directed-graph-using-dfs-g-19/
/*
*
* Time Complexity: O(V+E)+O(V) , where V = no. of nodes and E = no. of edges. There can be at most V components. So, another O(V) time complexity.

Space Complexity: O(2N) + O(N) ~ O(2N): O(2N) for two visited arrays and O(N) for recursive stack space.
* */
public class DetectCycleDirected {
    static boolean detectCycleDirected(List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        boolean[] pathVisited = new boolean[adjList.size()];

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                if (dfs(visited, pathVisited, adjList, i))
                    return true;
            }
        }
        return false;
    }

    static boolean dfs(boolean[] visited, boolean[] pathVisited, List<List<Integer>> adjList, int node) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int adjNode : adjList.get(node)) {
            if (!visited[node]) {
                if (dfs(visited, pathVisited, adjList, adjNode)) {
                    return true;
                }
            } else if (pathVisited[node]) {
                return true;
            }
        }
        pathVisited[node] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 11;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        boolean ans = detectCycleDirected(adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");

    }
}
