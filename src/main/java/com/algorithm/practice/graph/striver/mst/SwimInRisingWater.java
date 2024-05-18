package com.algorithm.practice.graph.striver.mst;

//Ref: https://leetcode.com/problems/swim-in-rising-water/description/

import java.util.HashMap;
import java.util.Map;

// Time : O(mn)
// Space: O(2mn)

public class SwimInRisingWater {
    static boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }

    static int minTime(int[][] graph) {
        int rows = graph.length;
        int cols = graph[0].length;
        DisjointSetsUnionBySize ds = new DisjointSetsUnionBySize(rows * cols);
        Map<Integer, Integer> map = new HashMap<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                map.put(graph[row][col], row * cols + col);
            }
        }

        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, -1, 0, 1};
        int depth = 0;
        while (ds.findParent(0) != ds.findParent(rows * cols - 1)) {
            depth++;
            int cRow = map.get(depth) / cols;
            int cCol = map.get(depth) % cols;
            for (int i = 0; i <= 3; i++) {
                int adjRow = cRow + dr[i];
                int adjCol = cCol + dc[i];
                if (isValid(adjRow, adjCol, rows, cols) && graph[cRow][cCol] > graph[adjRow][adjCol]) {
                    int currentNode = cRow * cols + cCol;
                    int adjNode = adjRow * cols + adjCol;
                    ds.unionBySize(currentNode, adjNode);
                }
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        System.out.println(minTime(new int[][]{{0, 2}, {1, 3}}));
    }
}
