package com.algorithm.practice.arrays;

public class MaxSubArray {

    public static void maxSubArray(int[] arr){
        int max = Integer.MIN_VALUE;
        int sum  = 0;
        int start =0;
        int ansStart = -1, ansEnd = -1;
        for(int i=0;i<arr.length;i++){
            if(sum==0){
                start =i;
            }
            sum = sum + arr[i];
            if(sum>max){
                ansStart = start;
                ansEnd = i;
                max = sum;
            }
            if(sum<0){
                sum = 0;
            }
        }
        System.out.println("Sum of max sub arr is: "+max);
        System.out.println("Max SubArray:");
        for (int i=ansStart;i<=ansEnd;i++){
            System.out.println(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        maxSubArray(new int[]{1,2,-7,3,4,5});
    }
}
