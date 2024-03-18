package com.algorithm.practice.dynamicprogramming;

public class WaysToTraverseGraph {

    // Solution 1
    // Simple recursion
    // TIme : O(2^(m+n)) | Space: O(m+n)


    // Time: O(n*m) | Space : O(n*m)
    // Solution 2 (DP)
    public int numberOfWaysToTraverseGraph(int width, int height) {
        int[][] ways = new int[height][width];
        for(int i=0;i<width;i++){
            ways[height-1][i]=1;
        }
        for(int i=0;i<height;i++){
            ways[i][width-1]=1;
        }
        for(int i=height-2;i>=0;i--){
            for(int j=width-2;j>=0;j--){
                ways[i][j]=ways[i][j+1]+ ways[i+1][j];
            }
        }
        return ways[0][0];
    }

    // Solution 3
    // Optimized memory (DP)
}
