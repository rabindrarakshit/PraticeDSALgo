package com.algorithm.practice.arrays.medium;

public class TransposeMatrix {
    public static void transpose(int[][] arr){
        for(int i=0;i< arr.length;i++){
            // Diagonal always stays the same in transpose so i+1 in next line
            for(int j=i+1;j<arr[0].length;j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int matrix[][] =  { {4,5,6}, {7,8,9}, {10,11,12}};
        transpose(matrix);
    }
}
