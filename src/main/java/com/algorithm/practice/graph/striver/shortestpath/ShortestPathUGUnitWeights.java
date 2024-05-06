package com.algorithm.practice.graph.striver.shortestpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Ref: https://takeuforward.org/data-structure/shortest-path-in-undirected-graph-with-unit-distance-g-28/
/*
* Time Complexity: O(M) { for creating the adjacency list from given list ‘edges’} + O(N + 2M) { for the BFS Algorithm} + O(N) { for adding the final values of the shortest path in the resultant array} ~ O(N+2M).

Where N= number of vertices and M= number of edges.

Space Complexity:  O( N) {for the stack storing the BFS} + O(N) {for the resultant array} + O(N) {for the dist array storing updated shortest paths} + O( N+2M) {for the adjacency list} ~ O(N+M) .
* */

public class ShortestPathUGUnitWeights {
    static int[] shortestPaths(int[][] arr, int vertices, int edges, int source) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            adjList.get(arr[i][0]).add(arr[i][1]);
            adjList.get(arr[i][1]).add(arr[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        int[] result = new int[vertices];
        for (int i = 0; i < vertices; i++) result[i] = (int) 1e9;
        result[source] = 0;
        while (!q.isEmpty()) {
            Integer node = q.poll();
            for (Integer adjNode : adjList.get(node)) {
                if (result[node] + 1 < result[adjNode]) {
                    result[adjNode] = result[node] + 1;
                    q.add(adjNode);
                }
            }
        }
        for (int i = 0; i < vertices; i++) {
            if (result[i] == 1e9) {
                result[i] = -1;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int n = 9, m = 10;
        int[][] edge = {{0, 1}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 2}, {2, 6}, {6, 7}, {7, 8}, {6, 8}};

        int res[] = shortestPaths(edge, n, m, 0);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
