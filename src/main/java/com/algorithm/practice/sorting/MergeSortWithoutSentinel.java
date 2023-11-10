package com.algorithm.practice.sorting;

public class MergeSortWithoutSentinel {
    public static void sort(int[] a, int p, int r) {
        //  System.out.println("p: "+p+ " r: "+r);
        if (p < r) {
            int q = (p + r) / 2;
            //      System.out.println("1: p: "+p+" q: "+q+ " r: "+r);
            sort(a, p, q);
            //      System.out.println("2: p: "+p+" q: "+q+ " r: "+r);
            sort(a, q + 1, r);
            System.out.println("3: p: " + p + " q: " + q + " r: " + r);
            merge(a, p, q, r);
        }
    }

    public static void merge(int[] a, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        int[] result = new int[n1 + n2];

        for (int i = 1; i <= n1; i++) {
            arr1[i - 1] = a[p + i - 1];
        }
        for (int i = 1; i <= n2; i++) {
            arr2[i - 1] = a[q + i];
        }

   //     arr1[n1] = 999;
   //     arr2[n2] = 999;

        int i = 0, j = 0;
        for (int k = p; k <= r; k++) {
            if ((j>=arr2.length) || (i<arr1.length && arr1[i] <= arr2[j])) {
                a[k] = arr1[i];
                i++;
            } else {
                a[k] = arr2[j];
                j++;
            }
        }
    }
}
