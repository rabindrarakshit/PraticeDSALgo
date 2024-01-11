package com.algorithm.practice.arrays.hard;

public class ElementsMoreThanNBy3 {
    static int[] findElements(int[] arr) {
        int ele1 = 0, ele2 = 0, cnt1 = 0, cnt2 = 0;

        for (int i = 0; i < arr.length; i++) {
            if (cnt1 == 0 && arr[i] != ele2) {
                ele1 = arr[i];
                cnt1++;
            } else if (cnt2 == 0 && arr[i] != ele1) {
                ele2 = arr[i];
                cnt2++;
            } else if (arr[i] == ele1) {
                cnt1++;
            } else if (arr[i] == ele2) {
                cnt2++;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        int verifyCount1 = 0;
        int verifyCount2 = 0;
        for (int i : arr) {
            if (i == ele1) verifyCount1++;
            if (i == ele2) verifyCount2++;
        }

        int[] res = new int[2];
        int minCount = (arr.length / 3) + 1;
        if (verifyCount1 >= minCount) res[0] = ele1;
        if (verifyCount2 >= minCount) res[1] = ele2;

        return res;

    }

    public static void main(String[] args) {
        for (int i : findElements(new int[]{1, 1, 1, 4, 2, 2, 2, 3})) System.out.print(i + " ");
    }
}
