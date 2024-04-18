package com.algorithm.practice.dynamicprogramming.twod;

// Ref: https://takeuforward.org/data-structure/minimum-path-sum-in-a-grid-dp-10/

public class MinimumPathTraverseGraph {

    // Tabular
    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 && col == 0) {
                    dp[0][0] = grid[0][0];
                    continue;
                }
                int top = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if (row > 0) {
                    top = dp[row - 1][col] + grid[row][col];
                }
                if (col > 0) {
                    left = dp[row][col - 1] + grid[row][col];
                }
                dp[row][col] = Math.min(top, left);
            }
        }
        return dp[rows - 1][cols - 1];
    }

    // recursion
    static int minPathSum(int[][] matrix, int r, int c) {
        if (r < 0 || c < 0) {
            return 1000;
        }
        if (r == 0 && c == 0) {
            return matrix[0][0];
        }
        return matrix[r][c] + Math.min(minPathSum(matrix, r - 1, c), minPathSum(matrix, r, c - 1));
    }

    public static void main(String[] args) {
        int matrix[][] = {
                {5, 9, 6},
                {11, 5, 2}
        };
        System.out.println(minPathSum(matrix));
        System.out.println(minPathSum(matrix, matrix.length-1, matrix[0].length-1));
    }
}
