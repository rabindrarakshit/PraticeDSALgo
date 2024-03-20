package com.algorithm.practice.dynamicprogramming.oned;

public class HouseRobber {
    static int maxRob(int[] houses){
        int[] housesExcludingFirst = new int[houses.length-1];
        int[] housesExcludingLast = new int[houses.length-1];

        for(int i=1;i<houses.length;i++){
            housesExcludingFirst[i-1] = houses[i];
        }
        for(int i=0;i<houses.length-1;i++){
            housesExcludingLast[i] = houses[i];
        }
        return Math.max(maxSumMemoryOpt(housesExcludingFirst), maxSumMemoryOpt(housesExcludingLast));
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
        System.out.println(maxRob(new int[]{1,5,1,2,6}));
    }
}
