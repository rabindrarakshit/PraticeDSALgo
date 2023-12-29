package com.algorithm.practice.sorting;

// Time Complexity: O(n^2)
// Space Complexity: O(1)

public class BubbleSort {
    public static int[] bubbleSort(int[] x) {
        for(int i=0; i<x.length-1;i++){
            for(int j=0; j<x.length-1-i;j++){
                if(x[j]>x[j+1]){
                    int temp = x[j];
                    x[j] = x[j+1];
                    x[j+1]= temp;
                }
            }
        }
        return x;
    }

    public static void main(String[] args) {
        int[] result = bubbleSort(new int[]{7,8,5,4,3});
        for(int i:result)
            System.out.print(i + " ");
    }
}
