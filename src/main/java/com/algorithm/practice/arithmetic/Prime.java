package com.algorithm.practice.arithmetic;

public class Prime {
    static boolean checkForPrime(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkForPrime(13));
        System.out.println(checkForPrime(12));
    }
}
