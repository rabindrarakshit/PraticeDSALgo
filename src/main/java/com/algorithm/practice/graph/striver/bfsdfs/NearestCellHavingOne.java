package com.algorithm.practice.graph.striver.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

// Ref: https://takeuforward.org/graph/distance-of-nearest-cell-having-1/
// Time : O(NxM + NxMx4) ~ O(N x M) | Space: ~O(n*m) (approx bcoz its 3 times the same)
public class NearestCellHavingOne {

    static class Node {
        int row;
        int col;
        int steps;

        Node(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    static int[][] nearestCellHavingOne(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        int[][] distance = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 1) {
                    q.add(new Node(row, col, 0));
                    visited[row][col] = true;
                }
            }
        }

        int[] deltaRow = {0, -1, 0, 1};
        int[] deltaCol = {-1, 0, 1, 0};

        while (!q.isEmpty()) {
            Node node = q.poll();
            distance[node.row][node.col] = node.steps;
            for (int i = 0; i < 4; i++) {
                int neighbourRow = node.row + deltaRow[i];
                int neighbourCol = node.col + deltaCol[i];
                if (neighbourRow < rows && neighbourCol < cols && neighbourRow >= 0 && neighbourCol >= 0 &&
                        !visited[neighbourRow][neighbourCol]) {
                    visited[neighbourRow][neighbourCol] = true;
                    q.add(new Node(neighbourRow, neighbourCol, node.steps + 1));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };

        int[][] ans = nearestCellHavingOne(grid);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}
