package com.algorithm.practice.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    static int findRowRColCElement(int row, int col) {
        return combination(row - 1, col - 1);
    }


    // Below is the optimized approach
    // The other approach is you can use the above method to calculate every element
    // Most important point is Row N has N elements (so N columns)

    static List<Integer> generateNRow(int n) {
        int prevElement = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i < n; i++) {
            prevElement = (prevElement * (n - i)) / i;
            list.add(prevElement);
        }
        return list;
    }

    static int combination(int n, int r) {
        int sum = 1;
        for (int i = 0; i < r; i++) {
            sum = (sum * (n - i)) / (i + 1);
        }
        return sum;
    }

    static List<List<Integer>> generatePascalsTriangle(int n) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(generateNRow(i));
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findRowRColCElement(3, 2));

        for (int i : generateNRow(4)) {
            System.out.print(i + " ");
        }
        System.out.println();

        generatePascalsTriangle(3).forEach(arr -> arr.forEach(e -> System.out.print(e + " ")));
    }
}
