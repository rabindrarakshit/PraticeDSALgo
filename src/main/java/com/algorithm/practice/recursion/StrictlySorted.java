package com.algorithm.practice.recursion;

public class StrictlySorted {
    public static void main(String[] args) {
        System.out.println(isStrictlySorted(new int[]{1,2,3,4,5}, 0));
    }

    public static boolean isStrictlySorted(int[] arr, int index){
        if(index==arr.length-1){
            return true;
        }
        if(arr[index]<arr[index+1]){
            return isStrictlySorted(arr, index+1);
        }else {
            return false;
        }
    }
}
