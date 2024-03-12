package com.algorithm.practice.greedy;

import java.util.Arrays;

public class TandemBicycles {
    public int tandemBicycle(
            int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest
    ) {
        int total = 0;
        Arrays.sort(redShirtSpeeds);
        if (fastest) {
            Arrays.sort(blueShirtSpeeds);
            reverseArrayInPlace(blueShirtSpeeds);
        } else {
            Arrays.sort(blueShirtSpeeds);
        }
        for (int i = 0; i < redShirtSpeeds.length; i++) {
            if (redShirtSpeeds[i] > blueShirtSpeeds[i]) {
                total += redShirtSpeeds[i];
            } else {
                total += blueShirtSpeeds[i];
            }
        }
        return total;
    }

    public void reverseArrayInPlace(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int temp = array[start];
            array[start++] = array[end];
            array[end--] = temp;
        }
    }
}
