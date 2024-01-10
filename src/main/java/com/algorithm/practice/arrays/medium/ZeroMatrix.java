package com.algorithm.practice.arrays.medium;

// Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire
// column and row to 0 and then return the matrix.
// https://takeuforward.org/data-structure/set-matrix-zero/

// Time Complexity: O(3MN) +O(M) +O(N)
// Space Complexity: O(1)

public class ZeroMatrix {
    public static void setZeroes(int[][] input){
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        for(int i=0;i<input.length;i++){
            if(input[i][0]==0){
                firstColumnHasZero = true;
                break;
            }
        }

        for(int i=0;i<input[0].length;i++){
            if(input[0][i]==0){
                firstRowHasZero = true;
                break;
            }
        }

        for(int i=0;i<input.length;i++){
            for(int j=0;j<input[0].length;j++){
                if(input[i][j]==0){
                    input[i][0]=0;
                    input[0][j]=0;
                }
            }
        }

        for(int i=0;i<input.length;i++){
            if(input[i][0]==0){
                makeRowZero(input, i);
            }
        }

        for(int i=0;i<input[0].length;i++){
            if(input[0][i]==0){
                makeColumnZero(input, i);
            }
        }

        if(firstRowHasZero){
            makeRowZero(input, 0);
        }

        if(firstColumnHasZero){
            makeColumnZero(input, 0);
        }
    }

    public static void makeRowZero(int input[][], int row){
        for(int j=0;j<input[0].length;j++){
            input[row][j]=0;
        }
    }
    public static void makeColumnZero(int input[][], int column){
        for(int j=0;j<input.length;j++){
            input[j][column]=0;
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
                System.out.print(input[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] input = new int[4][3];
        fillMatrices(input);
        input[1][1]=0;
        setZeroes(input);
        printMatrices(input);
    }
}
