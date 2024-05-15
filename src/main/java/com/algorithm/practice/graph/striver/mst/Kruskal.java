package com.algorithm.practice.graph.striver.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// Ref: https://takeuforward.org/data-structure/kruskals-algorithm-minimum-spanning-tree-g-47/

/*
* Time Complexity: O(N+E) + O(E logE) + O(E*4α*2)   where N = no. of nodes and E = no. of edges. O(N+E) for extracting
*  edge information from the adjacency list. O(E logE) for sorting the array consists of the edge tuples. Finally, we are using the disjoint set operations inside a loop.
* The loop will continue to E times. Inside that loop, there are two disjoint set operations like findUPar() and
*  UnionBySize() each taking 4 and so it will result in 4*2. That is why the last term O(E*4*2) is added.

Space Complexity: O(N) + O(N) + O(E) where E = no. of edges and N = no. of nodes. O(E) space is taken by the array that we are using to store the edge information. And in the disjoint set data structure, we are using two N-sized arrays i.e. a parent and a size array (as we are using unionBySize() function otherwise, a rank array of the same size if unionByRank() is used) which result in the first two terms O(N).*/
public class Kruskal {
    static class Edge implements Comparable<Edge> {
        int source;
        int dest;
        int weight;

        Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge) {
            return this.weight - edge.weight;
        }
    }

    static int findMSTSum(int[][] graph, int nodes) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            edges.add(new Edge(graph[i][0], graph[i][1], graph[i][2]));
        }
        Collections.sort(edges);
        int mstSum = 0;
        DisjointSetsUnionBySize disjointSet = new DisjointSetsUnionBySize(nodes);
        for (int i = 0; i < edges.size(); i++) {
            Edge e = edges.get(i);
            if (disjointSet.findParent(e.source) != disjointSet.findParent(e.dest))
                mstSum += e.weight;
            disjointSet.unionBySize(e.source, e.dest);
        }
        return mstSum;
    }

    public static void main(String[] args) {

        int[][] edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};
        System.out.println(findMSTSum(edges, 5));
    }
}
