package com.algorithm.practice.graph.striver.toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Ref: https://takeuforward.org/data-structure/kahns-algorithm-topological-sort-algorithm-bfs-g-22/

/*
Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.

Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the indegree array, and O(N) for the queue data structure used in BFS(where N = no.of nodes).
 */

public class KahnAlgo {
    static int[] topoSort(List<List<Integer>> adjList) {
        int[] inbound = new int[adjList.size()];
        Queue<Integer> q = new LinkedList<>();

        for (int node = 0; node < adjList.size(); node++) {
            for (int adjNode : adjList.get(node)) {
                inbound[adjNode]++;
            }
        }

        for (int i = 0; i < inbound.length; i++) {
            if (inbound[i] == 0) {
                q.add(i);
            }
        }

        int i = 0;
        int ans[] = new int[adjList.size()];
        while (!q.isEmpty()) {
            int node = q.poll();
            ans[i++] = node;

            for (int adjNode : adjList.get(node)) {
                inbound[adjNode]--;
                if (inbound[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }
        return ans;
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

        for (int i : topoSort(adj))
            System.out.println(i);

    }
}
