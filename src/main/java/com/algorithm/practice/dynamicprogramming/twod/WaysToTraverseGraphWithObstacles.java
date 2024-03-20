package com.algorithm.practice.dynamicprogramming.twod;

// ref: https://takeuforward.org/data-structure/grid-unique-paths-2-dp-9/
// time: O(n*m) | Space: O(n*m)
public class WaysToTraverseGraphWithObstacles {
    static int ways(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int ways[][] = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row >= 0 && col >= 0 && obstacleGrid[row][col] == 1) {
                    ways[row][col] = 0;
                    continue;
                }
                if (row == 0 && col == 0) {
                    ways[row][col] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if (row > 0) {
                    up = ways[row - 1][col];
                }
                if (col > 0) {
                    left = ways[row][col - 1];
                }
                ways[row][col] = up+left;
            }
        }
        return ways[rows-1][cols-1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0,1},{0,0}};
        System.out.println(ways(obstacleGrid));
    }
}
