package com.algorithm.practice.arrays.hard;

public class ElementsMoreThanNBy2 {
    static int findElement(int[] arr) {
        int element = -1;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==element) {
                count++;
            }else{
                if(count==0){
                    element = arr[i];
                    count++;
                }else{
                    count--;
                }
            }
        }

        int verifyCount = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==element){
                verifyCount++;
            }
        }
        if(verifyCount>(arr.length/2)){
            return element;
        }else return -1;

    }

    public static void main(String[] args) {
        System.out.println(findElement(new int[]{1,1,1,1,2,2,3}));
    }
}
