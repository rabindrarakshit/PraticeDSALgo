package com.algorithm.practice.graph.striver.mst;

// Ref: https://takeuforward.org/data-structure/making-a-large-island-dsu-g-52/
/*
* Time Complexity: O(N2)+O(N2) ~ O(N2) where N = total number of rows of the grid. Inside those nested loops,
* all the operations are taking apparently constant time. So, O(N2) for the nested loop only, is the time complexity.

Space Complexity: O(2*N2) where N = the total number of rows of the grid. This is for the two arrays i.e.
* parent array and size array of size N2 inside the Disjoint set.
* */

import java.util.HashSet;

public class LargestIsland {
    static boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }

    static int largestIsland(int[][] graph) {
        int rowLength = graph.length;
        int colLength = graph[0].length;
        DisjointSetsUnionBySize ds = new DisjointSetsUnionBySize(rowLength * colLength);

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                if (graph[row][col] == 1) {
                    int dr[] = {-1, 0, 1, 0};
                    int dc[] = {0, -1, 0, 1};
                    for (int ind = 0; ind <= 3; ind++) {
                        int adjR = row + dr[ind];
                        int adjC = col + dc[ind];
                        if (isValid(adjR, adjC, rowLength, colLength) && graph[adjR][adjC] == 1) {
                            int node = row * colLength + col;
                            int adjNode = adjR * colLength + adjC;
                            ds.unionBySize(node, adjNode);
                        }
                    }
                }
            }
        }

        int max = 0;
        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                int dr[] = {-1, 0, 1, 0};
                int dc[] = {0, -1, 0, 1};
                HashSet<Integer> components = new HashSet<>();
                if (graph[row][col] == 0) {
                    for (int ind = 0; ind <= 3; ind++) {
                        int adjR = row + dr[ind];
                        int adjC = col + dc[ind];
                        if (isValid(adjR, adjC, rowLength, colLength) && graph[adjR][adjC] == 1) {
                            int adjNode = adjR * colLength + adjC;
                            components.add(ds.findParent(adjNode));
                        }
                    }
                    int sum = 0;
                    for (Integer i : components) {
                        sum += ds.size.get(i);
                    }
                    max = Math.max(sum + 1, max);
                }
            }
        }
        for (int cellNo = 0; cellNo < rowLength * colLength; cellNo++) {
            max = Math.max(max, ds.size.get(ds.findParent(cellNo)));
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1, 1, 0}, {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 1, 1, 0}, {0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 1, 0}, {0, 0, 1, 1, 1, 0}
        };

        int ans = largestIsland(grid);
        System.out.println("The largest group of connected 1s is of size: " + ans);
    }
}
