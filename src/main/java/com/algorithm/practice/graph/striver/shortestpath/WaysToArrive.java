package com.algorithm.practice.graph.striver.shortestpath;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// Ref: https://takeuforward.org/data-structure/g-40-number-of-ways-to-arrive-at-destination/

public class WaysToArrive {

    static class Node {
        int nodeId;
        int weight;

        Node(int nodeId, int weight) {
            this.nodeId = nodeId;
            this.weight = weight;
        }
    }

    static List<List<Node>> createAdjList(int[][] roadsArray, int nodes) {
        List<List<Node>> roadsList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            roadsList.add(new ArrayList<>());
        }
        for (int[] network : roadsArray) {
            int source = network[0];
            int target = network[1];
            int delay = network[2];

            roadsList.get(source).add(new Node(target, delay));
            roadsList.get(target).add(new Node(source, delay));
        }
        return roadsList;
    }

    static int waysToArrive(int[][] roads, int src, int dest, int nodes) {
        List<List<Node>> roadsList = createAdjList(roads, nodes);
        int mod = (int) (1e9 + 7);
        int[][] weightFrequency = new int[nodes][2]; // 0-> weight 1->freq

        for (int i = 0; i < nodes; i++) {
            weightFrequency[i][0] = (int) 1e9;
        }

        weightFrequency[src][0] = 0;
        weightFrequency[src][1] = 1;

        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        q.add(src);

        while (!q.isEmpty()) {
            Integer node = q.poll();
            for (Node adjNode : roadsList.get(node)) {
                int destination = adjNode.nodeId;
                int weight = adjNode.weight + weightFrequency[node][0];

                if (weight < weightFrequency[destination][0]) {
                    weightFrequency[destination][0] = weight;
                    weightFrequency[destination][1] = weightFrequency[node][1];
                    q.add(adjNode.nodeId);
                } else if (weight == weightFrequency[destination][0]) {
                    weightFrequency[destination][1] = (weightFrequency[node][1] + weightFrequency[destination][1]) % mod;
                }
            }
        }
        return weightFrequency[dest][1] % mod;
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roadsArray = {{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
        int ans = waysToArrive(roadsArray, 0, n - 1, n);

        System.out.print(ans);
        System.out.println();
    }
}
