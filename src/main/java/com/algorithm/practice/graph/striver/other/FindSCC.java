package com.algorithm.practice.graph.striver.other;

// ref: https://takeuforward.org/graph/strongly-connected-components-kosarajus-algorithm-g-54/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
* Time Complexity: O(V+E) + O(V+E) + O(V+E) ~ O(V+E) , where V = no. of vertices, E = no. of edges.
*  The first step is a simple DFS, so the first term is O(V+E). The second step of reversing the graph and the third step,
* containing DFS again, will take O(V+E) each.

Space Complexity: O(V)+O(V)+O(V+E), where V = no. of vertices, E = no. of edges. Two O(V) for the visited array and the
* stack we have used. O(V+E) space for the reversed adjacent list.
* */

public class FindSCC {

    static void dfs1(List<List<Integer>> adjList, int[] visited, int node, Stack<Integer> stack) {
        visited[node] = 1;
        for (Integer adjNode : adjList.get(node)) {
            if (visited[adjNode] == 0) {
                dfs1(adjList, visited, adjNode, stack);
            }
        }
        stack.push(node);
    }

    static void dfs2(List<List<Integer>> reversedAdjList, int node, int[] visited) {
        visited[node] = 1;
        for (Integer adjNode : reversedAdjList.get(node)) {
            if (visited[adjNode] == 0) {
                dfs2(reversedAdjList, adjNode, visited);
            }
        }
    }

    static int findSCC(int[][] edges, int nodes) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            adjList.get(edges[i][0]).add(edges[i][1]);
        }
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[nodes];
        dfs1(adjList, visited, 0, stack);

        List<List<Integer>> reversedAdjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            reversedAdjList.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            reversedAdjList.get(edges[i][1]).add(edges[i][0]);
        }
        Arrays.fill(visited, 0);
        int count = 0;
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            if (visited[node] == 0) {
                count++;
                dfs2(reversedAdjList, node, visited);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {1, 0}, {0, 2},
                {2, 1}, {0, 3},
                {3, 4}
        };
        int ans = findSCC(edges, n);
        System.out.println("The number of strongly connected components is: " + ans);
    }
}
