package com.algorithm.practice.dynamicprogramming.partitionDP;

import java.util.Arrays;

public class EvaluateBooleanExpression {

    static int positiveWaysRecur(String str, int i, int j, int isTrue) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if ((isTrue == 1 && str.charAt(i) == 'T') || (isTrue == 0 && str.charAt(i) == 'F')) {
                return 1;
            } else return 0;
        }
        int ways = 0;
        for (int index = i + 1; index <= j - 1; index = index + 2) {
            int leftTrue = positiveWaysRecur(str, i, index - 1, 1);
            int leftFalse = positiveWaysRecur(str, i, index - 1, 0);
            int rightTrue = positiveWaysRecur(str, index + 1, j, 1);
            int rightFalse = positiveWaysRecur(str, index + 1, j, 0);

            if (str.charAt(index) == '&') {
                if (isTrue == 1) {
                    ways += leftTrue * rightTrue;
                } else {
                    ways += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                }
            } else if (str.charAt(index) == '|') {
                if (isTrue == 1) {
                    ways += leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;
                } else {
                    ways += leftFalse * rightFalse;
                }
            } else {
                if (isTrue == 1) {
                    ways += leftTrue * rightFalse + leftFalse * rightTrue;
                } else {
                    ways += leftFalse * rightFalse + leftTrue * rightTrue;
                }
            }
        }
        return ways;
    }

    static int positiveWaysRecurDP(String str, int i, int j, int isTrue, int[][][] dp) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            if ((isTrue == 1 && str.charAt(i) == 'T') || (isTrue == 0 && str.charAt(i) == 'F')) {
                return 1;
            } else return 0;
        }
        if (dp[i][j][isTrue] != -1) {
            return dp[i][j][isTrue];
        }
        int ways = 0;
        for (int index = i + 1; index <= j - 1; index = index + 2) {
            int leftTrue = positiveWaysRecurDP(str, i, index - 1, 1, dp);
            int leftFalse = positiveWaysRecurDP(str, i, index - 1, 0, dp);
            int rightTrue = positiveWaysRecurDP(str, index + 1, j, 1, dp);
            int rightFalse = positiveWaysRecurDP(str, index + 1, j, 0, dp);

            if (str.charAt(index) == '&') {
                if (isTrue == 1) {
                    ways += leftTrue * rightTrue;
                } else {
                    ways += leftTrue * rightFalse + leftFalse * rightTrue + leftFalse * rightFalse;
                }
            } else if (str.charAt(index) == '|') {
                if (isTrue == 1) {
                    ways += leftTrue * rightFalse + leftFalse * rightTrue + leftTrue * rightTrue;
                } else {
                    ways += leftFalse * rightFalse;
                }
            } else {
                if (isTrue == 1) {
                    ways += leftTrue * rightFalse + leftFalse * rightTrue;
                } else {
                    ways += leftFalse * rightFalse + leftTrue * rightTrue;
                }
            }
        }
        dp[i][j][isTrue] = ways;
        return ways;
    }

    static int positiveWaysRecurDP(String str, int i, int j, int isTrue) {
        int n = str.length();
        int[][][] dp = new int[n][n][2];
        for (int[][] arr : dp) {
            for (int[] narr : arr) {
                Arrays.fill(narr, -1);
            }
        }
        return positiveWaysRecurDP(str, i, j, isTrue, dp);
    }

    public static void main(String[] args) {
        String str = "T|F&T";
        System.out.println(positiveWaysRecurDP(str, 0, str.length() - 1, 1));
    }
}
