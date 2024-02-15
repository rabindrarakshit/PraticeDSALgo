package com.algorithm.practice.stack;

import java.util.Stack;

public class CelebrityProblem {
    // Time: O(2N)
    // Space: O(N)
    static int findCelebrity(int[][] arr) {
        Stack<Integer> stack = new Stack<>();
        int res = -1;
        for (int i = 0; i < arr.length; i++) {
            stack.push(i);
        }
        while (stack.size() > 1) {
            int x = stack.pop();
            int y = stack.pop();
            if (arr[x][y] == 1) {
                stack.push(y);
            } else {
                stack.push(x);
            }
        }
        if (stack.isEmpty()) {
            return -1;
        } else {
            res = stack.pop();
        }
        for (int i = 0; i < arr.length; i++) {
            if (res != i && (arr[res][i] == 1 || arr[i][res] == 0)) {
                return -1;
            }
        }
        return res;
    }

    // Time: O(3N)
    // Space : O(1)
    static int findCelebrity2(int[][] arr) {
        int r = 0;
        int res = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[r][i] == 1) {
                arr[r][r] = 1;
                r = i;
            } else {
                arr[i][i] = 1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][i] == 0) {
                res = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (res != i && (arr[res][i] == 1 || arr[i][res] == 0)) {
                return -1;
            }
        }
        return res;
    }

    // Two Pointer
    // Time: O(2N)
    // Space : O(1)
    static int findCelebrity3(int[][] arr) {
        int i = 0;
        int j = arr.length - 1;
        int res = -1;
        while (i < j) {
            if (arr[i][j] == 1) {
                i++;
            } else {
                j--;
            }
        }
        res = i;
        for (int k = 0; k < arr.length; k++) {
            if (res != k && (arr[res][k] == 1 || arr[k][res] == 0)) {
                return -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int MATRIX[][] = {{0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}};
        System.out.println(findCelebrity3(MATRIX));
    }
}
