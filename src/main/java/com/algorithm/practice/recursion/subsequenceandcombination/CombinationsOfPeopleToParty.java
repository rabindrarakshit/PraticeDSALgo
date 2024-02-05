package com.algorithm.practice.recursion.subsequenceandcombination;

// Find the number of ways in which you can invite n people to your party, single or in pairs

public class CombinationsOfPeopleToParty {
    public static void main(String[] args) {
        System.out.println(count(4));
    }

    public static int count(int n){
        if(n<=1){
            return 1;
        }
        return count(n-1) + (n-1)*count(n-2);
    }
}
