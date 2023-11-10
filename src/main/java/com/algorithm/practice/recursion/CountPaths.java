package com.algorithm.practice.recursion;

public class CountPaths {
    private static int m=3, n=3;
    public static void main(String[] args) {
        System.out.println(countPaths(0,0));
    }

    public static int countPaths(int i, int j){
        if(i==m||j==n){
            return 0;
        }
        if(i==m-1&&j==n-1){
            return 1;
        }
        return countPaths(i+1,j) + countPaths(i,j+1);
    }
}
