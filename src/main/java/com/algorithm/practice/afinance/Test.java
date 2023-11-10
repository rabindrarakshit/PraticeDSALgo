package com.algorithm.practice.afinance;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, -7, 4, 5};
        int cur_max = arr[0];
        int global_max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            cur_max = Math.max(arr[i], cur_max + arr[i]);
            global_max = Math.max(cur_max, global_max);
        }
        System.out.println(global_max);
    }
}
