package com.algorithm.practice.dynamicprogramming.oned;

public class MaxSumNonAdjacent {
    static int maxSumDP(int[] array) {
        if(array.length==0){
            return 0;
        }else if(array.length==1){
            return array[0];
        }
        int[] maxSums = new int[array.length];
        maxSums[0] = array[0];
        maxSums[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            maxSums[i]= Math.max(maxSums[i-1], (maxSums[i-2]+array[i]));
        }
        return maxSums[array.length-1];
    }

    static int maxSumMemoryOpt(int[] array) {
        if(array.length==0){
            return 0;
        }else if(array.length==1){
            return array[0];
        }
        int first = Math.max(array[0], array[1]);
        int second = array[0];
        int current;
        for (int i = 2; i < array.length; i++) {
            current= Math.max(first, (second+array[i]));
            second = first;
            first = current;
        }
        return first;
    }

    public static void main(String[] args) {
        int[] array = new int[]{75, 105, 120, 75, 90, 135};
        System.out.println(maxSumDP(array));
        System.out.println(maxSumMemoryOpt(array));
    }
}
