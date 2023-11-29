package com.algorithm.practice.arrays;

public class DutchNationalFlag {
    public static void main(String[] args) {
        int[] input = new int[]{2,1,0,2};
        for(int i:sort012(input)){
            System.out.println(i);
        }
    }

    public static int[] sort012(int[] arr){
        int low = 0,mid = 0;
        int high = arr.length -1;

        while(mid<high){
            if(arr[mid]==0){
                // Swap low and mid and increment both
                int temp= arr[low];
                arr[low] = arr[mid];
                arr[mid]= temp;
                low++;
                mid++;
            }
            if(arr[mid]==1){
                mid++;
            }
            if(arr[mid]==2){
                int temp = arr[high];
                arr[high] = arr[mid];
                arr[mid]= temp;
                high--;
            }
        }
        return arr;
    }
}
