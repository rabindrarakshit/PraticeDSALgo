package com.algorithm.practice.arrays.easy;

import java.util.List;

public class SortedSquaredArray {
    Integer[] sortedSquaredArray(Integer[] input){
        int begin = 0;
        int end = input.length-1;
        Integer[] result = new Integer[input.length];
        int idx = input.length-1;
        while(begin<end){
            if(Math.abs(input[begin])>=Math.abs(input[end])){
                result[idx--]= input[begin++];
            }else {
                result[idx--]= input[end--];
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
