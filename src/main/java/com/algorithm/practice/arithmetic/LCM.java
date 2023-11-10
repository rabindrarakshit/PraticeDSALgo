package com.algorithm.practice.arithmetic;

public class LCM {
    public static int bruteforce(int n1, int n2){
        int max_value = n1>n2? n1 : n2;
        while(true){
            if((max_value % n1 == 0) && (max_value % n2 == 0)){
                break;
            }
            max_value++;
        }
        return max_value;
    }

    public static int gcd_approach(int n1, int n2){
        int gcd = HCF.recursive(n1,n2);
        return (n1*n2)/gcd;
    }
}
