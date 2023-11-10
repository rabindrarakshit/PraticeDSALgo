package com.algorithm.practice.bitmanipulation;

public class BitManipulation {

    public static void main(String[] args) {
        System.out.println(set(5, 1));
    }

    public static int get(int input, int pos){
        int bitMask = 1<<pos;
        int result = input & bitMask;
        return result>0 ? 1 : 0;
    }
    public static int clear(int input, int pos){
        int bitMask = 1<<pos;
        int result = input & ~bitMask;
        return result;
    }
    public static int set(int input, int pos){
        int bitMask = 1<<pos;
        int result = input | bitMask;
        return result;
    }
    public int update(int input, int pos, int updateValue){
        // if updateValue is 1 then use set, if updateValue is 0 then use clear
        return 0;
    }
}
