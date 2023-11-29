package com.algorithm.practice.arrays;

import com.sun.source.tree.Tree;

import java.util.Set;
import java.util.TreeSet;

public class MaxDiff2ElementsOrderDoesNotMatter {
    static int maxDiff(int[] arr){
        int max=arr[0], min=arr[0];
        for(int i=1; i<arr.length; i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        return max-min;
    }

    public static void main(String[] args) {
        System.out.println(maxDiff(new int[]{9,5,2,3,1}));
    }
}
