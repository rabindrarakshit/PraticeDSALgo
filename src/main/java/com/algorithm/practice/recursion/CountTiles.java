package com.algorithm.practice.recursion;

public class CountTiles {
    private static int rows = 4, columns = 4;

    public static void main(String[] args) {
        System.out.println(placeTiles(4, 2));
    }

    // MySolution
    // Not sure if it will pass all test cases
    public static int countTiles(int i) {
        if (i >= rows) {
            return 0;
        }
        if (i == rows - 1) {
            return 1;
        }
        return countTiles(i + 3) + countTiles(i + 1);
    }

    public static int placeTiles(int n, int m) {
        if (n == m) {
            return 2;
        }
        if (n < m) {
            return 1;
        }
        return placeTiles(n - m, m) + placeTiles(n - 1, m);
    }
}
