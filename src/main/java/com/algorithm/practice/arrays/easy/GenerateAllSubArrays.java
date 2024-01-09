package com.algorithm.practice.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubArrays {
    public static void generateAllSubarrays(String str){
        List<String> list = new ArrayList<>();
        for(int i=0; i<str.toCharArray().length;i++){
            for(int j=i+1;j<str.toCharArray().length;j++){
                list.add(str.substring(i,j));
            }
        }
        list.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        generateAllSubarrays("aabbbccc");
    }
}
