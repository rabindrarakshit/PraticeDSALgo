package com.algorithm.practice.arrays.medium;

// Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire
// column and row to 0 and then return the matrix.
// https://takeuforward.org/data-structure/set-matrix-zero/

// Time Complexity: O(MN)*O(M+N) + O(MN) = O(MN)(M+N+1)
// Space Complexity: O(1)

public class ZeroMatricesFloodMinusOne {
    static void zeroMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    makeRowZero(arr, i);
                    makeColumnZero(arr, j);
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void makeRowZero(int input[][], int row) {
        for (int j = 0; j < input[0].length; j++) {
            if (input[row][j] != 0) {
                input[row][j] = -1;
            }
        }
    }

    public static void makeColumnZero(int input[][], int column) {
        for (int j = 0; j < input.length; j++) {
            if (input[j][column] != 0) {
                input[j][column] = -1;
            }
        }
    }

    public static void fillMatrices(int[][] input) {
        int count = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                count++;
                input[i][j] = count;
            }
        }
    }

    public static void printMatrices(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[4][3];
        fillMatrices(input);
        input[1][1] = 0;
        zeroMatrix(input);
        printMatrices(input);
    }
}
