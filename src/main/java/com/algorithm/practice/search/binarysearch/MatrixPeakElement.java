package com.algorithm.practice.search.binarysearch;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class MatrixPeakElement {

    static int findMax(int[][] arr, int mid) {
        int max = -1;
        int maxIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][mid] > max) {
                max = arr[i][mid];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    static int[] findPeak(int[][] arr) {
        int lowC = 0;
        int highC = arr[0].length - 1;

        while (lowC <= highC) {
            int mid = lowC + (highC - lowC) / 2;
            int maxI = findMax(arr, mid);

            int left = mid - 1 >= 0 ? arr[maxI][mid - 1] : -1;
            int right = mid + 1 <= arr[0].length - 1 ? arr[maxI][mid + 1] : -1;

            if (arr[maxI][mid] > left && arr[mid][maxI] > right) {
                return new int[]{maxI, mid};
            }
            if (arr[mid][maxI] > left) {
                lowC = mid + 1;
            } else {
                highC = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
       /* int[][] arr = {{1, 4, 8},
                {2, 1, 4},
                {1, 2, 5}};
        for (int i : findPeak(arr)) {
            System.out.println(i);
        }*/

        LocalDate date = LocalDate.now();
        System.out.println(date);
        date.plusDays(3);
        System.out.println(date);
        Instant.now().atZone(ZoneOffset.UTC).toLocalDate();
    }
}
