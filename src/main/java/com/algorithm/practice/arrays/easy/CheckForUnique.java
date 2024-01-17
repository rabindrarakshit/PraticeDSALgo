package com.algorithm.practice.arrays.easy;

public class CheckForUnique {
    public static boolean checkIfUnique(char[] arr){
        boolean[] letters = new boolean[26];
        for(int i=0;i<arr.length;i++){
            if(letters[arr[i]-'a']){
                return false;
            }
            letters[arr[i]-'a'] = true;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkIfUnique(new char[]{'a','b','c','d','e'}));
    }
}
