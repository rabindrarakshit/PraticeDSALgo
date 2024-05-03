package com.algorithm.practice.graph.striver.toposort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Kahn's algo to detect a cycle using BFS
/*
Time Complexity: O(V+E), where V = no. of nodes and E = no. of edges. This is a simple BFS algorithm.

Space Complexity: O(N) + O(N) ~ O(2N), O(N) for the indegree array, and O(N) for the queue data structure used in BFS(where N = no.of nodes).
 */

public class DetectCycleDirectedBFS {
    static boolean detectCycle(List<List<Integer>> adjList) {
        Queue<Integer> q = new LinkedList<>();
        int[] inbound = new int[adjList.size()];

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

        if (i == adjList.size())
            return false;
        else
            return true;
    }

    public static void main(String[] args) {
        int V = 11;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
      /*  adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);
*/

        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);


        boolean ans = detectCycle(adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
