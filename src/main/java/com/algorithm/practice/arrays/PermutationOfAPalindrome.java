package com.algorithm.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class PermutationOfAPalindrome {
    public static Boolean check(String str) {
        str = str.replace(" ", "");
        str = str.toLowerCase();
        int oddCounts = 0;
        int[] map = new int[128];
        for (char i : str.toCharArray()) {
            map[i]++;
            if(map[i]%2==0){
                oddCounts--;
            }else{
                oddCounts++;
            }
        }
        return oddCounts > 1 ? false : true;
    }

    public static void main(String[] args) {
        System.out.println(check("abc"));
        System.out.println(check("aba"));
    }
}
