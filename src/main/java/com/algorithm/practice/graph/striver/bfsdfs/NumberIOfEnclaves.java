package com.algorithm.practice.graph.striver.bfsdfs;

// Ref: https://takeuforward.org/graph/number-of-enclaves/
// Time Complexity: O(N) + O(M) + O(NxMx4) ~ O(N x M)
// Space Complexity ~ O(N x M), O(N x M)
public class NumberIOfEnclaves {
    static class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static void dfs(char[][] matrix, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        int[] deltaRow = {0, -1, 0, 1};
        int[] deltaCol = {-1, 0, 1, 0};

        for (int i = 0; i < 4; i++) {
            int neighbourRow = deltaRow[i] + row;
            int neighbourCol = deltaCol[i] + col;
            if (neighbourRow < visited.length && neighbourCol < visited[0].length && neighbourRow >= 0 && neighbourCol >= 0 &&
                    !visited[neighbourRow][neighbourCol]) {
                if (matrix[neighbourRow][neighbourCol] == '1') {
                    dfs(matrix, neighbourRow, neighbourCol, visited);
                }
            }
        }
    }

    static int surroundedRegions(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            //First Col
            if (!visited[i][0] && matrix[i][0] == '1') {
                dfs(matrix, i, 0, visited);
            }
            // Last Col
            if (!visited[i][cols - 1] && matrix[i][cols - 1] == '1') {
                dfs(matrix, i, cols - 1, visited);
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            //First Row
            if (!visited[0][i] && matrix[0][i] == '1') {
                dfs(matrix, 0, i, visited);
            }
            // Last Row
            if (!visited[rows - 1][i] && matrix[rows - 1][i] == '1') {
                dfs(matrix, rows - 1, i, visited);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && matrix[i][j] == '1') {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        char grid[][] = {
                {'0', '0', '0', '0'},
                {'1', '0', '1', '0'},
                {'0', '1', '1', '0'},
                {'0', '0', '1', '0'},
                {'0', '0', '0', '0'}};


        // n = 5, m = 4
        System.out.println(surroundedRegions(grid));
    }
}
