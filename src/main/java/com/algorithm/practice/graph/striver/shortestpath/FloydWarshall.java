package com.algorithm.practice.graph.striver.shortestpath;

// Ref: https://takeuforward.org/data-structure/floyd-warshall-algorithm-g-42/

/*
* Time Complexity: O(V3), as we have three nested loops each running for V times, where V = no. of vertices.

Space Complexity: O(V2), where V = no. of vertices. This space complexity is due to storing the adjacency matrix of the given graph.
*
* If we apply Dijkstra here (incase of no negative loops) then we have a complexity of O(VElog(V))
* */

public class FloydWarshall {
    static int[][] shortestPath(int[][] graph) {
        int nodes = graph.length;
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (graph[i][j] == -1) {
                    graph[i][j] = (int) 1e9;
                }
                if (i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        // incase its mentioned graph has negative edges
        /*for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (graph[i][j] < 0) {
                    return new int[][]{{-1}};
                }
            }
        }*/


        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                if (graph[i][j] == (int) 1e9) {
                    graph[i][j] = -1;
                }
            }
        }
        return graph;
    }
}
