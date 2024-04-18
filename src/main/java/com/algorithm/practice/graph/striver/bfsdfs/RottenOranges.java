package com.algorithm.practice.graph.striver.bfsdfs;

//Ref: https://takeuforward.org/data-structure/rotten-oranges-min-time-to-rot-all-oranges-bfs/

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class Pair {
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    static int minTime(int[][] oranges) {
        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[oranges.length][oranges[0].length];
        int freshOranges = 0;
        for (int row = 0; row < oranges.length; row++) {
            for (int col = 0; col < oranges[0].length; col++) {
                if (oranges[row][col] == 2) {
                    Pair p = new Pair(row, col, 0);
                    q.add(p);
                }
                if (oranges[row][col] == 1) {
                    freshOranges++;
                }
            }
        }
        int[] nRow = {-1, 0, 1, 0};
        int[] nCol = {0, -1, 0, 1};

        int freshToRot = 0;
        int time = -1;
        while (!q.isEmpty()) {
            Pair p = q.poll();
            time = Math.max(time, p.time);
            for (int i = 0; i < 4; i++) {
                int cRow = p.row + nRow[i];
                int cCol = p.col + nCol[i];
                if (cRow >= 0 && cRow < oranges.length && cCol >= 0 && cCol < oranges[0].length
                        && visited[cRow][cCol] == 0 && oranges[cRow][cCol] == 1) {
                    freshToRot++;
                    oranges[cRow][cCol] = 2;
                    q.add(new Pair(cRow, cCol, p.time + 1));
                    visited[cRow][cCol] = 2;
                }
            }
        }
        if (freshToRot == freshOranges) {
            return time;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] oranges = {{0, 1, 2}, {0, 1, 2}, {2, 1, 1}};
        System.out.println(minTime(oranges));
    }
}
