package com.algorithm.practice.arrays.medium;

// Source: AlgoExpert

public class TransposeMatrix {

    // Works only n*n matrix
    public static void transpose(int[][] arr){
        for(int i=0;i< arr.length;i++){
            // Diagonal always stays the same in transpose so i+1 in next line
            for(int j=i+1;j<arr[0].length;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }

    // Common solution
    static public int[][] transposeMatrix(int[][] matrix) {
        int[][] res = new int[matrix[0].length][matrix.length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                res[j][i]=matrix[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //int matrix[][] =  { {4,5,6}, {7,8,9}, {10,11,12}};
        int matrix[][] =  { {4,5,6}};
        transposeMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
