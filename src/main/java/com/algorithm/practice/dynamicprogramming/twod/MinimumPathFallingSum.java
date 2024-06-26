package com.algorithm.practice.dynamicprogramming.twod;

public class MinimumPathFallingSum {
    static int minSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] sums = new int[rows][cols];

        for (int col = 0; col < cols; col++) {
            sums[0][col] = grid[0][col];
        }

        for (int row = 1; row < rows; row++) {
            int top = Integer.MAX_VALUE;
            int topLeft = Integer.MAX_VALUE;
            int topRight = Integer.MAX_VALUE;
            for (int col = 0; col < cols; col++) {
                top = sums[row - 1][col] + grid[row][col];
                if (col > 0) {
                    topLeft = sums[row - 1][col - 1] + grid[row][col];
                }
                if (col + 1 < cols) {
                    topRight = sums[row - 1][col + 1] + grid[row][col];
                }
                sums[row][col] = Math.min(top, Math.min(topLeft, topRight));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int col = 0; col < cols; col++) {
            min = Math.min(min, sums[rows - 1][col]);
        }
        return min;
    }

    static int maxSum(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || c >= grid[0].length) {
            return 0;
        }
        if (r == 0 || c == 0) {
            return grid[r][c];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            int top = grid[r][i] + maxSum(grid, r - 1, i);
            int topLeft = grid[r][i] +maxSum(grid, r - 1, i + 1);
            int topRight = grid[r][i] + maxSum(grid, r - 1, i - 1);
            int currentSum = Math.max(Math.max(top, topLeft), topRight);
            max = Math.max(max, currentSum);
        }
        return max;
    }

    public static void main(String[] args) {
        int matrix[][] = {{2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}};
        System.out.println(minSum(matrix));
        System.out.println(maxSum(matrix, matrix.length-1, matrix[0].length-1));
    }
}
