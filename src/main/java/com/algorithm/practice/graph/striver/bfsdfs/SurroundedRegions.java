package com.algorithm.practice.graph.striver.bfsdfs;

// Ref: https://takeuforward.org/graph/surrounded-regions-replace-os-with-xs/
// Time Complexity: O(N) + O(M) + O(NxMx4) ~ O(N x M)
// Space Complexity ~ O(N x M), O(N x M)
public class SurroundedRegions {
    static class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static void dfs(char[][] matrix, int row, int col, boolean[][] visited) {

        int[] deltaRow = {0, -1, 0, 1};
        int[] deltaCol = {-1, 0, 1, 0};

        for (int i = 0; i < 4; i++) {
            int neighbourRow = deltaRow[i] + row;
            int neighbourCol = deltaCol[i] + col;
            if (neighbourRow < visited.length && neighbourCol < visited[0].length && neighbourRow >= 0 && neighbourCol >= 0 &&
                    !visited[neighbourRow][neighbourCol]) {
                if (matrix[neighbourRow][neighbourCol] == 'O') {
                    visited[neighbourRow][neighbourCol] = true;
                    dfs(matrix, neighbourRow, neighbourCol, visited);
                }
            }
        }
    }

    static char[][] surroundedRegions(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < matrix[0].length; i++) {
            //First Row
            if (!visited[0][i] && matrix[0][i] == 'O') {
                visited[0][i] = true;
                dfs(matrix, i, 0, visited);
            }
            // Last Row
            if (!visited[0][i] && matrix[rows - 1][i] == 'O') {
                visited[rows - 1][i] = true;
                dfs(matrix, 0, i, visited);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            //First Column
            if (!visited[0][i] && matrix[i][0] == 'O') {
                visited[i][0] = true;
            }
            // Last Column
            if (!visited[0][i] && matrix[i][cols - 1] == 'O') {
                visited[i][cols - 1] = true;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && matrix[i][j] == 'O') {
                    matrix[i][j] = 'X';
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        char mat[][] = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};

        // n = 5, m = 4
        char[][] ans = surroundedRegions(mat);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}



/*

I solved it assuming we needed to cross out those O's which had 'X' on all four sides. But here it does not say
about individual points but as a region of O's.

*   static char[][] surroundedRegions(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        char[][] transformed = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 'O') {
                    q.add(new Node(row, col));
                } else {
                    transformed[row][col] = matrix[row][col];
                }
            }
        }

        int[] deltaRows = {0, -1, 0, 1};
        int[] deltaCols = {-1, 0, 1, 0};

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int neighbourRow = node.row + deltaRows[i];
                int neighbourCol = node.col + deltaCols[i];
                if (neighbourRow < rows && neighbourCol < cols && neighbourRow >= 0 && neighbourCol >= 0) {
                    if (matrix[neighbourRow][neighbourCol] != 'X') {
                        transformed[node.row][node.col] = matrix[node.row][node.col];
                        break;
                    }
                }
                if (i == 3) {
                    transformed[node.row][node.col] = 'X';
                }
            }
        }
        return transformed;
    }
*
* */
