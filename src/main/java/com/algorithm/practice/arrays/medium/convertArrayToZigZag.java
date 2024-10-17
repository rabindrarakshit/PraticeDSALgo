package com.algorithm.practice.arrays.medium;

public class convertArrayToZigZag {
    public static void convertArrayToZigZag(int[] arr){
        Boolean flag = true; // "<"
        for(int i=0; i<arr.length -1; i++){
            if(flag){
                if(arr[i]>arr[i+1]){
                    swap(arr, i);
                }
            }
            if(!flag){
                if(arr[i]<arr[i+1]){
                    swap(arr,i);
                }
            }
            flag = !flag;
        }

    }

    private static void swap(int[] arr, int i){
        int temp = arr[i];
        arr[i] = arr[i+1];
        arr[i+1] = temp
        ;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{1,2,3,4,5};
        convertArrayToZigZag(arr);
        for(int i:arr){
            System.out.println(i);
        }

    }
}
