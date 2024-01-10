package com.algorithm.practice.arrays.medium;

// Ref: Problem Statement: Given an array, print all the elements which are leaders.
// A Leader is an element that is greater than all of the elements on its right side in the array.
// https://takeuforward.org/data-structure/leaders-in-an-array/


import java.util.ArrayList;
import java.util.List;

public class LeadersInAnArray {
    static List<Integer> leaders(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int max = arr[arr.length-1];
        res.add(max);
        for(int i=arr.length-2;i>=0;i--){
            if(arr[i]>max){
                res.add(arr[i]);
                max = arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for(int i: leaders(new int[]{4,2,3,1})){
            System.out.print(i+" ");
        }
    }

}
