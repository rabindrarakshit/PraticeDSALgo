package com.gfg.arrays;

public class SumOfTwoRoman {
    public static void main(String[] args) {
        String s1 = "I";
        String s2 = "V";
        System.out.println(IntToRoman.intToRoman(RomanToInt.romanToInt(s1)+RomanToInt.romanToInt(s2)));
    }
}
