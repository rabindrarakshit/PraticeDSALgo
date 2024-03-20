package com.algorithm.practice.dynamicprogramming.twod;

// Ref: https://takeuforward.org/data-structure/minimum-path-sum-in-a-grid-dp-10/

import java.util.Arrays;

public class MinimumPathTraverseGraph {

    // Memoization
    public int pathSum(int[][] grid, int i, int j, int dp[][]) {
        if (i == 0 || j == 0) {
            return dp[i][j];
        }
        if (dp[i][j] > 0) return dp[i][j];
        dp[i][j] = (Math.min(pathSum(grid, i - 1, j, dp), pathSum(grid, i, j - 1, dp)) + grid[i][j]);
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        return pathSum(grid, grid.length - 1, grid[0].length - 1, dp);
    }


    // Tabular
    public static int ways(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] ways = new int[rows][cols];

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(row==0 && col==0){
                    ways[0][0] = grid[0][0];
                    continue;
                }
                int top=Integer.MAX_VALUE;
                int left=Integer.MAX_VALUE;
                if(row>0){
                    top = ways[row-1][col] + grid[row][col];
                }
                if(col>0){
                    left = ways[row][col-1] + grid[row][col];
                }
                ways[row][col] = Math.min(top,left);
            }
        }
        return ways[rows-1][cols-1];
    }

    public static void main(String[] args) {
        int matrix[][] = {
                {5, 9, 6},
                {11, 5, 2}
        };
        System.out.println(ways(matrix));
    }
}
