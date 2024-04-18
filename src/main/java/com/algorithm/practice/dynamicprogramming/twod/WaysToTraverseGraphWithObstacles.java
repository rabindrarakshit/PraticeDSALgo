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
                ways[row][col] = up + left;
            }
        }
        return ways[rows - 1][cols - 1];
    }

    static int waysRecusrsion2(int r, int c, int[][] maze) {
        if (r == 0 && c == 0) {
            return 1;
        }
        if (r < 0 || c < 0) {
            return 0;
        }
        if (r >= 0 && c >= 0 && maze[r][c] == 1) {
            return 0;
        }
        return waysRecusrsion2(r - 1, c, maze) + waysRecusrsion2(r, c - 1, maze);
    }

    // My alternative - Not good
    static int waysRecursion(int r, int c, int[][] maze) {
        if (r == 0) {
            for (int i = 0; i <= c; i++) {
                if (maze[0][i] == 1) {
                    return 0;
                }
            }
            return 1;
        }
        if (c == 0) {
            for (int i = 0; i <= r; i++) {
                if (maze[i][0] == 1) {
                    return 0;
                }
            }
            return 1;
        }
        return waysRecursion(r - 1, c, maze) + waysRecursion(r, c - 1, maze);
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][]{{0, 1}, {0, 0}};
        System.out.println(ways(obstacleGrid));
        System.out.println(waysRecursion(obstacleGrid.length - 1, obstacleGrid[0].length - 1, obstacleGrid));
        System.out.println(waysRecusrsion2(obstacleGrid.length - 1, obstacleGrid[0].length - 1, obstacleGrid));
    }
}
