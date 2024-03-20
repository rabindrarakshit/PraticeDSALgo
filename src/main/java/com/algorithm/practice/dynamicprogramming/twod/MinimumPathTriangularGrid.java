package com.algorithm.practice.dynamicprogramming.twod;

import java.util.Arrays;

public class MinimumPathTriangularGrid {
    // Tabular
    static int ways(int[][] grid) {
        int rows = grid.length;
        int[][] ways = new int[rows][rows];
        for (int[] row : ways) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col <= row; col++) {
                if (row == 0 && col == 0) {
                    ways[0][0] = grid[0][0];
                    continue;
                }
                int top = Integer.MAX_VALUE;
                int topleft = Integer.MAX_VALUE;
                if (row > 0 && ways[row - 1][col] != Integer.MIN_VALUE) {
                    top = ways[row - 1][col] + grid[row][col];
                }
                if (col > 0) {
                    topleft = ways[row - 1][col - 1] + grid[row][col];
                }
                ways[row][col] = Math.min(top, topleft);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int col = 0; col < rows; col++) {
            min = Math.min(min, ways[rows - 1][col]);
        }
        return min;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}};
        System.out.println(ways(matrix));
    }
}
