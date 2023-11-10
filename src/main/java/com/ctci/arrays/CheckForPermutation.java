package com.ctci.arrays;

public class CheckForPermutation {
    public static Boolean checkByIndexArray(String str1, String str2){
        Boolean isPermutation = true;
        char[] inputString = str1.toCharArray();
        char[] testString = str2.toCharArray();
        int[] integerArray = new int[128]; // ASCII length = 128, different for unicode
        for(char i: inputString){
            integerArray[i] = 1;
        }
        for(char i: testString){
            integerArray[i]--;
            if(integerArray[i]<0){
                isPermutation = false;
                break;
            }
        }
        return isPermutation;
    }

}
