package com.algorithm.practice.graph.striver.shortestpath;

// Ref: https://takeuforward.org/data-structure/bellman-ford-algorithm-g-41/

/*
* Time Complexity: O(V*E), where V = no. of vertices and E = no. of Edges.

Space Complexity: O(V) for the distance array which stores the minimized distances.
*
* */
public class BellmanFord {

    static int[] shortestDistances(int vertices, int[][] graph, int start) {
        //List<List<Node>> adjList = createAdjList(graph, vertices);
        int[] distance = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            distance[i] = (int) 1e8;
        }
        distance[start] = 0;
        for (int i = 0; i < vertices - 1; i++) {
            for (int[] edge : graph) {
                int source = edge[0];
                int dest = edge[1];
                int weight = edge[2];
                if (distance[source] != (int) 1e8 && distance[source] + weight < distance[dest]) {
                    distance[dest] = distance[source] + weight;
                }
            }
        }

        for (int[] edge : graph) {
            int source = edge[0];
            int dest = edge[1];
            int weight = edge[2];
            if (distance[source] != (int) 1e8 && distance[source] + weight < distance[dest]) {
                return new int[]{-1};
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        int V = 6;
        int[][] edges = new int[][]{{3, 2, 6}, {5, 3, 1}, {0, 1, 5}, {1, 5, -3}, {1, 2, -2}, {3, 4, -2}, {2, 4, 3}};
        int[] dist = shortestDistances(V, edges, 0);
        for (int i = 0; i < V; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println("");
    }
}
