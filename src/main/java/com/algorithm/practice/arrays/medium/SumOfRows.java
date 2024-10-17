package com.algorithm.practice.arrays.medium;

public class SumOfRows {
    static int[] sumOfRows(int[][] arr){
        int auxArr[] =  new int[arr.length];
        for(int i = 0; i<arr.length; i++){
            int sum = 0;
            for(int j = 0; j<arr[i].length; j++){
                sum = sum+arr[i][j];
            }
            auxArr[i] = sum;
        }
        return auxArr;
    }

    public static void main(String[] args) {

    }
}
