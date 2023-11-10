package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

// Here it is on the assumption second will be higher freq and that will always happen at sometime because at first second will go from a-z when first is a.
// And then first will become b and son on, where second will start from a
public class MaxVariance {
    public static int maxVariance(char[] arr) {
        int[] freq = new int[26];
        int max_variance = 0;
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i] - 'a']++;
        }
        for (int first = 0; first < 26; first++) {
            for (int second = 0; second < 26; second++) {
                int remaining_first = freq[first];
                int remaining_second = freq[second];
                if (first == second || remaining_first == 0 || remaining_second == 0) {
                    continue;
                }
                int freq_first = 0;
                int freq_second = 0;
                for (int i = 0; i < arr.length; i++) {
                    if ((arr[i] - 'a') == second) {
                        freq_second++;
                    }
                    if ((arr[i] - 'a') == first) {
                        freq_first++;
                        remaining_first--;
                    }
                    if (freq_first > 0) {
                        max_variance = Math.max(max_variance, freq_second - freq_first);
                    }
                    if (freq_second < freq_first && remaining_first >= 1) {
                        freq_second = 0;
                        freq_first = 0;
                    }
                }
            }
        }
        return max_variance;
    }

    public static void main(String[] args) {
        String s = "bbaaaaa";
        System.out.println(maxVariance(s.toCharArray()));
        Stack<Integer> st = new Stack<>();
        st.peek();
    }
}
