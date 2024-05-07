package com.algorithm.practice.graph.striver.shortestpath;

//Ref: https://takeuforward.org/data-structure/g-36-shortest-distance-in-a-binary-maze/

import java.util.Comparator;
import java.util.PriorityQueue;

public class BinaryMaze {
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

    static int shortestPath(int[][] matrix, int srcRow, int srcCol, int targetRow, int targetCol) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] distance = new int[rows][cols];
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));

        pq.add(new Node(srcRow, srcCol, 0));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                distance[i][j] = (int) 1e9;
            }
        }
        distance[srcRow][srcCol] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int dist = node.distance;
            int row = node.row;
            int col = node.col;

            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, -1, 0, 1};

            for (int i = 0; i < 4; i++) {
                int nRow = dRow[i] + row;
                int nCol = dCol[i] + col;

                if (nRow < rows && nRow >= 0 && nCol >= 0 && nCol < cols && dist + 1 < distance[nRow][nCol]
                        && matrix[nRow][nCol] == 1) {
                    distance[nRow][nCol] = dist + 1;
                    if (nRow == targetRow && nCol == targetCol) {
                        return dist + 1;
                    }
                    pq.add(new Node(nRow, nCol, dist + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
                {1, 0, 0, 1}};
        int res = shortestPath(grid, 0, 1, 2, 2);
        System.out.print(res);
        System.out.println();
    }
}
