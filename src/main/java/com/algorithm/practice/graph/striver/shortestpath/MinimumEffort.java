package com.algorithm.practice.graph.striver.shortestpath;

import java.util.Comparator;
import java.util.PriorityQueue;

// Ref: https://takeuforward.org/data-structure/g-37-path-with-minimum-effort/
/*Time Complexity: O( 4*N*M * log( N*M) ) { N*M are the total cells, for each of which we also check 4 adjacent nodes for the minimum effort and additional log(N*M) for insertion-deletion operations in a priority queue }

Where, N = No. of rows of the binary maze and M = No. of columns of the binary maze.

Space Complexity: O( N*M ) { Distance matrix containing N*M cells + priority queue in the worst case containing all the nodes ( N*M) }.

Where, N = No. of rows of the binary maze and M = No. of columns of the binary maze.*/


public class MinimumEffort {
    static class Node {
        int row;
        int col;
        int distance;

        public Node(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    static int minimumEffort(int[][] matrix, int srcRow, int srcCol, int targetRow, int targetCol) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] distance = new int[rows][cols];
        PriorityQueue<BinaryMaze.Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));

        pq.add(new BinaryMaze.Node(srcRow, srcCol, 0));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                distance[i][j] = (int) 1e9;
            }
        }
        distance[srcRow][srcCol] = 0;

        while (!pq.isEmpty()) {
            BinaryMaze.Node node = pq.poll();
            int dist = node.distance;
            int row = node.row;
            int col = node.col;

            if (row == targetRow && col == targetCol) {
                return dist;
            }

            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, -1, 0, 1};

            for (int i = 0; i < 4; i++) {
                int nRow = dRow[i] + row;
                int nCol = dCol[i] + col;
                if (nRow < rows && nRow >= 0 && nCol >= 0 && nCol < cols) {
                    int absDiff = Math.abs(matrix[nRow][nCol] - matrix[row][col]);
                    int newEffort = Math.max(absDiff, dist);
                    if (newEffort < distance[nRow][nCol]) {
                        distance[nRow][nCol] = newEffort;
                        pq.add(new BinaryMaze.Node(nRow, nCol, newEffort));
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        int ans = minimumEffort(heights, 0, 0, 2, 2);
        System.out.print(ans);
        System.out.println();
    }
}
