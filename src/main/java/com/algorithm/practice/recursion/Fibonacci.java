package com.algorithm.practice.recursion;

import javax.ws.rs.BadRequestException;
import java.util.ArrayList;
import java.util.List;

public class Fibonacci {
    public static void main(String[] args) throws Exception {
        for(int i: itr_fibonacci(5)){
            System.out.println();
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println("Recursive : ");
        int a =0;
        int b= 1;
        System.out.print(a+" "+b+ " ");
        recure_fibo(a,b,5);
    }

    public static List<Integer> itr_fibonacci(int n) throws Exception {
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            throw new Exception("Invalid Input!!");
        }
        if (n == 1) {
            result.add(0);
            return result;
        }
        if (n == 2) {
            result.addAll(List.of(0,1));
            return result;
        }
        result.addAll(List.of(0,1));
        for (int i = 3; i <= n;i++) {
            result.add(result.get(result.size()-1) + result.get(result.size()-2));
        }
        return result;
    }

    public static void recure_fibo(int a, int b, int n){
        if(n>0){
            int cur = a + b;
            System.out.print(cur + " ");
            recure_fibo(b, cur, n-1);
        }
        return;
    }
}
