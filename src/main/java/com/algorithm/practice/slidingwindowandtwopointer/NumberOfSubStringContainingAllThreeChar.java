package com.algorithm.practice.slidingwindowandtwopointer;

public class NumberOfSubStringContainingAllThreeChar {

    // Sliding Window
    // Time: O(N)
    // Space: O(1)
    static int getTotalSubString1(char[] arr) {
        int[] count = new int[]{0, 0, 0};
        int i = 0, res = 0;
        for (int j = 0; j < arr.length; j++) {
            count[arr[j] - 'A']++;
            if (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                count[i++]--;
                res = res + i;
            }
        }
        return res;
    }


    static int getTotalSubString2(char[] arr) {
        int res = 0, n = arr.length;
        int[] count = new int[]{-1, -1, -1};
        for (int i = 0; i < n; i++) {
            count[arr[i]-'A']=i;
            res += 1+ Math.min(count[0], Math.min(count[1], count[2]));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getTotalSubString1(new char[]{'A', 'B', 'C', 'A'}));
        System.out.println(getTotalSubString2(new char[]{'A', 'B', 'C', 'A'}));
    }
}
