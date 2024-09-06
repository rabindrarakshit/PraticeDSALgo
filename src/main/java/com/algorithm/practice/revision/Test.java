package com.algorithm.practice.revision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {

    static boolean isValid(int adjRow, int adjCol, int rows, int cols) {
        return adjRow >= 0 && adjRow < rows && adjCol >= 0 && adjCol < cols;
    }

    static List<List<Integer>> createAdjListForUndirectedGraph(int[][] graph, int nodes) {

        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            adjList.get(graph[i][0]).add(graph[i][1]);
            adjList.get(graph[i][1]).add(graph[i][0]);
        }
        return adjList;
    }

    static List<List<Node>> createAdjListForWeightedUndirectedGraph(int[][] graph, int nodes) {
        List<List<Node>> adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            adjList.get(graph[i][0]).add(new Node(graph[i][1], graph[i][2]));
            adjList.get(graph[i][1]).add(new Node(graph[i][0], graph[i][2]));
        }
        return adjList;
    }

    static List<List<Integer>> createAdjListForDirectedGraph(int[][] graph, int nodes) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            adjList.get(graph[i][0]).add(graph[i][1]);
        }
        return adjList;
    }

    static class Node {
        int node;
        int weight;

        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static class NodeWithHops {
        int node;
        int weight;

        int hops;

        NodeWithHops(int node, int weight, int hops) {
            this.node = node;
            this.weight = weight;
            this.hops = hops;
        }
    }


    static int numberOfWays(int[][] graph, int nodes) {
        List<List<Node>> adjList = createAdjListForWeightedUndirectedGraph(graph, nodes);
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        int[] distance = new int[nodes];
        pq.add(new Node(0, 0));
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0;
        int[] ways = new int[nodes];
        ways[0] = 1;
        int mod = (int) (1e9 + 7);
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            for (Node adjNode : adjList.get(node.node)) {
                int cost = adjNode.weight + distance[node.node];
                if (cost < distance[adjNode.node]) {
                    ways[adjNode.node] = ways[node.node];
                    distance[adjNode.node] = cost;
                    pq.add(new Node(adjNode.node, cost));
                } else if (cost == distance[adjNode.node]) {
                    ways[adjNode.node] = (ways[node.node] + ways[adjNode.node]) % mod;
                }
            }
        }
        return ways[nodes - 1] % mod;
    }

    static int minOperations(int[] numbers, int start, int end) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        int mod = 100000;
        int dist[] = new int[mod];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start]=0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < numbers.length; i++) {
                int prod = (node.node * numbers[i]) % mod;
                if (prod == end) {
                    return node.weight + 1;
                } else if (node.weight + 1 < dist[prod]) {
                    dist[prod] = node.weight + 1;
                    q.add(new Node(prod, node.weight + 1));
                }
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{2, 5, 7}, 3, 30));
    }
}
