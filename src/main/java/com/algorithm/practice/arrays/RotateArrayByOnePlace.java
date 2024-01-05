package com.algorithm.practice.arrays;

public class RotateArrayByOnePlace {
    static void rotate(int[] arr){
        int temp = arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[arr.length-1]= temp;
    }

    public static void main(String[] args) {
        int[] arr =  new int[]{1,2,3,4,5};
        rotate(arr);
        for(int i : arr){
            System.out.println(i);
        }
    }
}
