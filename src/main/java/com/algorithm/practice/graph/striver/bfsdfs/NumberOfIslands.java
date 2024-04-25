package com.algorithm.practice.graph.striver.bfsdfs;

// Ref: https://takeuforward.org/data-structure/number-of-islands/

public class NumberOfIslands {

    static void dfs(int row, int col, int[][] matrix, boolean[][] visited) {
        visited[row][col] = true;

        /*   for(int delrow = -1; delrow<=1;delrow++) {
             for(int delcol = -1; delcol <= 1; delcol++) {

             Instead of the next three lines you can also have the above two lines
         */

        int[] diffRows = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] diffCols = {-1, -1, 0, 1, 1, 1, 0, -1};
        for (int i = 0; i < 8; i++) {
            int neighbourRow = diffRows[i] + row;
            int neighbourCol = diffCols[i] + col;

            if (neighbourRow >= 0 && neighbourCol >= 0 && neighbourRow < matrix.length && neighbourCol < matrix[0].length &&
                    !visited[neighbourRow][neighbourCol] && matrix[neighbourRow][neighbourCol] == 1) {
                dfs(neighbourRow, neighbourCol, matrix, visited);
            }
        }
    }

    static int numberOfIslands(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!visited[row][col] && matrix[row][col] == 1) {
                    count++;
                    dfs(row, col, matrix, visited);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 1, 0}
        };
        System.out.println(numberOfIslands(grid));
    }
}
