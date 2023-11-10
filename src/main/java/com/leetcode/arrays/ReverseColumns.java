package com.leetcode.arrays;

public class ReverseColumns {
    public static void reverseColumns(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<(arr.length/2);j++){
                int temp = arr[j][i];
                arr[j][i] = arr[arr.length-1-j][i];
                arr[arr.length-1-j][i] = temp;
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
        reverseColumns(matrix);
    }
}
