package com.algorithm.practice.search.binarysearch;

public class ArrayPeakElement {

    static int findPeak(int[] arr){
        if(arr.length==1){
            return 0;
        }
        if(arr[0]>arr[1]){
            return 0;
        }
        if(arr[arr.length-1]>arr[arr.length-2]){
            return arr.length-1;
        }
        int low =1;
        int high = arr.length-2;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                return mid;
            }
            if(arr[mid]>arr[mid-1]){
                low= mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findPeak(new int[]{1,2,3,6,5,4}));
        System.out.println(findPeak(new int[]{1,1,1,1}));
    }
}
