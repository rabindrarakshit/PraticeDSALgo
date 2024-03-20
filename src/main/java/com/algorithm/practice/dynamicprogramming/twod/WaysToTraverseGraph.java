package com.algorithm.practice.dynamicprogramming.twod;

public class WaysToTraverseGraph {

    // Solution 1
    // Simple recursion
    // TIme : O(2^(m+n)) | Space: O(m+n)


    // Time: O(n*m) | Space : O(n*m)
    // Solution 2 (DP - Tabulation- Top-Down)
    public int numberOfWaysToTraverseGraph(int width, int height) {
        int[][] ways = new int[height][width];
        for (int i = 0; i < width; i++) {
            ways[height - 1][i] = 1;
        }
        for (int i = 0; i < height; i++) {
            ways[i][width - 1] = 1;
        }
        for (int i = height - 2; i >= 0; i--) {
            for (int j = width - 2; j >= 0; j--) {
                ways[i][j] = ways[i][j + 1] + ways[i + 1][j];
            }
        }
        return ways[0][0];
    }

    // Time: O(n*m) | Space : O(n*m)
    // Solution 2 (DP - Tabulation- Bottom-Up)
    static int ways(int m, int n) {
        int[][] ways = new int[m][n];
        for (int i = 0; i < n; i++) {
            ways[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            ways[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
            }
        }
        return ways[m - 1][n - 1];
    }

    // Solution 3
    // Optimized memory (DP)
    static int waysMemoryOptimized(int m, int n) {
        if(m==1 || n==1){
            return 1;
        }
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = 1;
        }
        for (int row = 1; row < m; row++) {
            int[] cur = new int[n];
            for (int col = 1; col < n; col++) {
                cur[0] = 1;
                cur[col] = cur[col - 1] + prev[col];
            }
            prev = cur;
        }
        return prev[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(waysMemoryOptimized(2, 1));
    }

}
