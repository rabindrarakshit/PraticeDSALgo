package com.algorithm.practice.recursion;

public class TowerOfHanoi {
    public static void main(String[] args) {
        impl(3, "S", "H", "D");
    }
    public static void impl(int n, String src, String helper, String dest) {
        if (n > 0) {
            impl(n - 1, src, dest, helper);
            System.out.println("Transferring Disk " + n + " from " + src + " to " + dest);
            impl(n - 1, helper, src, dest);
        }
    }
}
