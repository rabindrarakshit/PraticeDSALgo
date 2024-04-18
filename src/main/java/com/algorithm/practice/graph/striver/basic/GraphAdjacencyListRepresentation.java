package com.algorithm.practice.graph.striver.basic;

import java.util.ArrayList;

//Ref: https://www.youtube.com/watch?v=OsNklbh9gYI&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=3
// https://takeuforward.org/graph/graph-representation-in-c/

public class GraphAdjacencyListRepresentation {

    // 3 nodes - 1,2,3
    // 3 edges - 1-2, 1-3, 2-3
    // Undirected graph
    // We always store indexes in adj list.
    static void graphRep() {
        int nodes = 3;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= nodes; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(1).add(1);
        adjList.get(2).add(1);

        adjList.get(1).add(3);
        adjList.get(3).add(1);

        adjList.get(2).add(3);
        adjList.get(3).add(2);

        // Print the edges
    }
}
