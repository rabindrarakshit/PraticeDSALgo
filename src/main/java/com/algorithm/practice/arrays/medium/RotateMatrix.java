package com.algorithm.practice.arrays.medium;

public class RotateMatrix {
    public static void rotateMatrix(int[][] input) {
        if (input.length != input[0].length) {
            return;
        }
        int n = input.length;
        for (int level = 0; level < n / 2; level++) {
            int first = level;
            int last = n - level - 1;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = input[first][i];
                // left->top
                input[first][i] = input[last - offset][first];
                // bottom -> left
                input[last - offset][first] = input[last][last - offset];
                //right -> bottom
                input[last][last - offset] = input[i][last];
                //top-> right
                input[i][last] = top;
            }
        }
    }

    public static void printMatrices(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                System.out.println(input[i][j]);
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

    public static void main(String[] args) {
        int[][] input = new int[3][3];
        fillMatrices(input);
        rotateMatrix(input);
        printMatrices(input);
    }
}
