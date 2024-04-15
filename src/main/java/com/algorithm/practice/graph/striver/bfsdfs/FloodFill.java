package com.algorithm.practice.graph.striver.bfsdfs;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    static class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static void floodFill(int row, int col, int[][] matrix, int newColour) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        int initialColour = matrix[row][col];
        matrix[row][col] = newColour;
        int[] nRow = {-1, 0, 1, 0};
        int[] nCol = {0, -1, 0, 1};


        while (!q.isEmpty()) {
            Pair p = q.poll();
            visited[p.row][p.col] = true;
            for (int i = 0; i < 4; i++) {
                int cRow = p.row + nRow[i];
                int cCol = p.col + nCol[i];
                if (cRow >= 0 && cCol >= 0 && cRow < matrix.length && cCol < matrix[0].length && !visited[cRow][cCol]) {
                    if (matrix[cRow][cCol] == initialColour) {
                        matrix[cRow][cCol] = newColour;
                        q.add(new Pair(cRow, cCol));
                        visited[cRow][cCol] = true;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        floodFill(1, 1, image, 2);

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }
}
