package com.algorithm.practice.arrays.medium;

public class RotateMatrix {
    // This is for clock wise rotation, if we need anti-clock then we just do transpose and then reverse columns
    static void rotateByTransposeAndReverseApproach(int[][] arr){
        TransposeMatrix.transpose(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length/2;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[i][arr[0].length-j-1];
                arr[i][arr[0].length-j-1] = temp;
            }
        }
    }

    public static void rotateMatrixByLevelsApproach(int[][] input) {
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
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
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
        rotateByTransposeAndReverseApproach(input);
        printMatrices(input);
    }
}
