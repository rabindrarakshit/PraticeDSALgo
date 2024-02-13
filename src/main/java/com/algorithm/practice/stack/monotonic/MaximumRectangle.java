package com.algorithm.practice.stack.monotonic;

import java.util.Stack;

//Ref: https://leetcode.com/problems/maximal-rectangle/description/

public class MaximumRectangle {

    // My implementation according to previous problems
    public static int maximalRectangle(int[][] matrix) {
        int rLen = matrix.length, cLen = matrix[0].length, res = 0, h[] = new int[cLen];
        for (int i = 0; i < rLen; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int j = 0; j <= cLen; j++) {
                if (j < cLen) {
                    if (matrix[i][j] == 1) {
                        h[j]++;
                    } else {
                        h[j] = 0;
                    }
                }
                int cur = j < cLen ? h[j] : Integer.MIN_VALUE;
                while (stack.peek() != -1 && cur < h[stack.peek()]) {
                    res = Math.max(res, h[stack.pop()] * (j - stack.peek() - 1));
                }
                stack.push(j);
            }
        }
        return res;
    }


    // Leetcode reference implementation
    public static int maximalRectangle1(int[][] matrix) {
        int rLen = matrix.length, cLen = rLen == 0 ? 0 : matrix[0].length, max = 0;
        int[] h = new int[cLen + 1];
        for (int row = 0; row < rLen; row++) {
            Stack<Integer> s = new Stack<>();
            s.push(-1);
            for (int i = 0; i <= cLen; i++) {
                if (i < cLen && matrix[row][i] == 1)
                    h[i] += 1;
                else h[i] = 0;
                while (s.peek() != -1 && h[i] < h[s.peek()]) {
                    max = Math.max(max, h[s.pop()] * (i - s.peek() - 1));
                }
                s.push(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 0, 1, 0, 0}, {1, 0, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 0, 0, 1, 0}};
        System.out.println(maximalRectangle(arr));
    }

}
