package com.algorithm.practice.core;

public class SwitchCase {
    public static void main(String[] args) {
        System.out.println(9/5);
        System.out.println(check());
    }

    public static int check(){
        int test = 5;
        switch(test){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                return 0;
        }
    }
}
