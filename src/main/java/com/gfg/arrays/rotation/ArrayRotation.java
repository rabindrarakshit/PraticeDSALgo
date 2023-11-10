package com.gfg.arrays.rotation;

import com.algorithm.practice.arithmetic.HCF;
import com.gfg.arrays.Reverse;

public class ArrayRotation {
    public static int[] rotateByN (int[] arr, int n){
       // arr[0] = 99;
        int[] rotatedArray = new int[arr.length];
        int j=0;
        for (int i = n; i>0; i--){
            rotatedArray[arr.length - i] = arr[j];
            j++;
        }
        for(int i=0; i<arr.length-n; i++){
            rotatedArray[i] = arr[i+n];
        }
        return rotatedArray;
    }

    public static int[] rotateByJuggleBlockSwap(int[] arr, int d) {
        int n = arr.length;
        int temp, j, k;
        d = d % n;
        int gcd = HCF.recursive(d, n);
        for (int i = 0; i < gcd; i++) {
            temp = arr[i];
            j = i;
            while (true) {
                k = j + d;
                System.out.println(k);
                if (k >= n) {
                    k = k - n;
                }
                if (k == i) {
                    break;
                }
                arr[j] = arr[k];
                j=k;
            }
            arr[j] = temp;
        }
        return arr;
    }

    public static void leftRotateByReverse(int[] arr, int d){
        int n =  arr.length;
        Reverse.reverse(arr, 0, d-1);
        Reverse.reverse(arr, d, n-1);
        Reverse.reverse(arr, 0, n-1);
    }

    public static void rightRotateByReverse(int[] arr, int d){
        int n =  arr.length;
        Reverse.reverse(arr, n-d, n-1);
        Reverse.reverse(arr, 0, n-d-1);
        Reverse.reverse(arr, 0, n-1);
    }
}
