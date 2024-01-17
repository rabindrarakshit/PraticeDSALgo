package com.algorithm.practice.string.easy;

import java.util.Arrays;

public class LongestCommonPrefix {
    static String longestCommonPrefix(String[] str) {
        Arrays.sort(str);
        StringBuilder prefix = new StringBuilder();
        String firstStr = str[0], lastStr = str[str.length - 1];
        for (int i = 0; i < Math.min(firstStr.length(), lastStr.length()); i++) {
            if (firstStr.charAt(i) == lastStr.charAt(i)) {
                prefix.append(firstStr.charAt(i));
            } else break;
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(arr));
    }
}
