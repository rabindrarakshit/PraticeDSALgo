package com.algorithm.practice.graph.striver.mst;

// Ref: https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2
/*
* Time Complexity: O(E*logE) + O(E*logE)~ O(E*logE), where E = no. of given edges.
The maximum size of the priority queue can be E so after at most E iterations the priority queue will be empty and the loop will end.
* Inside the loop, there is a pop operation that will take logE time. This will result in the first O(E*logE) time complexity. Now, inside that loop, for every node, we need to traverse all its adjacent nodes where the number of nodes can be at most E. If we find any node unvisited, we will perform a push operation and for that, we need a logE time complexity. So this will result in the second O(E*logE).

Space Complexity: O(E) + O(V), where E = no. of edges and V = no. of vertices. O(E) occurs due to the size of the priority queue
* and O(V) due to the visited array. If we wish to get the mst, we need an extra O(V-1) space to store the edges of the most.
*
* */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Prim {
    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static int findMSTSum(int V, List<List<List<Integer>>> adjList) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.weight));
        boolean visited[] = new boolean[V];

        pq.add(new Pair(0, 0));
        int count = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;

            if (visited[node]) continue;
            visited[node] = true;
            count += p.weight;

            for (List<Integer> edge : adjList.get(node)) {
                int adjNode = edge.get(0);
                int weight = edge.get(1);
                if (!visited[adjNode]) {
                    pq.add(new Pair(adjNode, weight));
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int V = 5;
        List<List<List<Integer>>> adj = new ArrayList<>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }


        int sum = findMSTSum(V, adj);
        System.out.println("The sum of all the edge weights: " + sum);
    }
}
