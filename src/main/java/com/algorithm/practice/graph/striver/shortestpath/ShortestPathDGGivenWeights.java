package com.algorithm.practice.graph.striver.shortestpath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//Ref: https://takeuforward.org/data-structure/shortest-path-in-directed-acyclic-graph-topological-sort-g-27/

public class ShortestPathDGGivenWeights {

    static class Pair {
        int vertex;
        int distance;

        Pair(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    // Time: O(v+e)
    // Space: O(v+e)

    static int[] shortestPaths(int[][] graph, int vertices, int edges) {
        // Create Adjacency List
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            Pair p = new Pair(graph[i][1], graph[i][2]);
            adjList.get(graph[i][0]).add(p);
        }

        int[] distances = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        distances[0] = 0;

        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(x -> x.distance));;
        q.add(new Pair(0, 0));
        while (!q.isEmpty()) {
            Pair node = q.poll();
            List<Pair> adjNodes = adjList.get(node.vertex);
            for (Pair p : adjNodes) {
                int dist = p.distance;
                if (distances[node.vertex] + dist < distances[p.vertex]) {
                    distances[p.vertex] = distances[node.vertex] + dist;
                    q.add(p);
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edge = {{0, 1, 2}, {0, 4, 1}, {4, 5, 4}, {4, 2, 2}, {1, 2, 3}, {2, 3, 6}, {5, 3, 1}};
        int res[] = shortestPaths(edge, n, m);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
