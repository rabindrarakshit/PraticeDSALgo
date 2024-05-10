package com.algorithm.practice.graph.striver.shortestpath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Ref: https://leetcode.com/problems/network-delay-time/description/
// time: O(v+e)
// space: O(v+e)
public class NetworkDelayTime {

    static class Node {
        int nodeId;
        int delay;

        Node(int nodeId, int delay) {
            this.nodeId = nodeId;
            this.delay = delay;
        }
    }

    static List<List<Node>> createAdjList(int[][] networkArray, int nodes) {
        List<List<Node>> networkList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            networkList.add(new ArrayList<>());
        }
        for (int[] network : networkArray) {
            int source = network[0];
            int target = network[1];
            int delay = network[2];

            networkList.get(source).add(new Node(target, delay));
        }
        return networkList;
    }

    static int minimumDelay(int[][] networkArray, int nodes, int src) {
        nodes++; // Only because leetcode had it 1 based
        List<List<Node>> networkList = createAdjList(networkArray, nodes);
        int[] delays = new int[nodes];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < nodes; i++) {
            delays[i] = (int) 1e9;
        }

        q.add(src);
        delays[src] = 0;
        delays[0] = 0; // Because its One based
        while (!q.isEmpty()) {
            int nodeId = q.poll();
            for (Node adjNode : networkList.get(nodeId)) {
                int currentNodeId = adjNode.nodeId;
                int currentNodeDelay = adjNode.delay + delays[nodeId];

                if (currentNodeDelay < delays[currentNodeId]) {
                    delays[currentNodeId] = currentNodeDelay;
                    q.add(currentNodeId);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < delays.length; i++) {
            if (delays[i] == (int) 1e9) {
                return -1;
            } else if (delays[i] > max) {
                max = delays[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] networkArray = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        int ans = minimumDelay(networkArray, 4, 2);

        System.out.print(ans);
        System.out.println();
    }
}
