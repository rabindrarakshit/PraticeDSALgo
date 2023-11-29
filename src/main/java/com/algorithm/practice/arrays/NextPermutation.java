package com.algorithm.practice.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutation {
    public static List<Integer> nextGreaterPermutation(List<Integer> input){
        // find the cross-point
        int n = input.size();
        int point = -1;
        for(int i=n-2;i>=0;i--){
            if(input.get(i)<input.get(i+1)){
                point = i;
                break;
            }
        }

        for(int i=n-1;i>point;i--){
            if(input.get(i)>input.get(point)){
                int temp = input.get(point);
                input.set(point, input.get(i));
                input.set(i, temp);
                break;
            }
        }

        List<Integer> subList = input.subList(point+1, n);
        Collections.reverse(subList);
        return input;
    }

    public static void main(String[] args) {
        List<Integer> result = nextGreaterPermutation(Arrays.asList(2, 1, 5, 4, 3, 0, 0));
        result.forEach(System.out::println);
    }
}
