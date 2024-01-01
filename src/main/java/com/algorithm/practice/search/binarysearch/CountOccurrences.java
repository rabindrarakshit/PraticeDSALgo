package com.algorithm.practice.search.binarysearch;

public class CountOccurrences {
    static int lowerBound(int[] arr, int num){
        int low = 0;
        int high = arr.length - 1;
        int lBound = Integer.MAX_VALUE;

        while(low<high){
            int mid = low + (high-low)/2;
            if(arr[mid]<num){
                low = mid+1;
            }else{
                lBound = mid;
                high = mid -1;
            }
        }
        return lBound;
    }

    static int upperBound(int[] arr, int num){
        int low = 0;
        int high = arr.length - 1;
        int hBound = Integer.MIN_VALUE;

        while(low<high){
            int mid = low + (high-low)/2;
            if(arr[mid]<=num){
                hBound = mid;
                low = mid+1;
            }else{
                high = mid -1;
            }
        }
        return hBound;
    }

    static int countOccurrences(int[] arr){
        return upperBound(arr, 5) - lowerBound(arr, 5) + 1;
    }

    public static void main(String[] args) {
        System.out.println(countOccurrences(new int[] {1,2,3,5,5,5,6}));
    }
}
