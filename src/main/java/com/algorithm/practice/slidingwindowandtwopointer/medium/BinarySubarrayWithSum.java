package com.algorithm.practice.slidingwindowandtwopointer.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Ref: https://leetcode.com/problems/binary-subarrays-with-sum/description/

public class BinarySubarrayWithSum {
    public static int numSubarraysWithSum(int[] A, int S) {
        return atMost(A, S) - atMost(A, S - 1);
    }

    public static int atMost(int[] A, int S) {
        if (S < 0) return 0;
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            S -= A[j];
            while (S < 0)
                S += A[i++];
            res += j - i + 1;
        }
        return res;
    }

    public static int prefixSum(int[] A, int S) {
        int pSum = 0, res = 0;
        int[] count = new int[A.length + 1];
        count[0] = 1;
        for (int i = 0; i < A.length; i++) {
            pSum += A[i];
            if (pSum > S) {
                res += count[pSum - S];
            }
            count[pSum]++;
        }
        return res;
    }

    /*
    TLDR; Two Sum + Prefix Sum Caching

Logic: In this problem we are required to find some interval [i:j] ,i < j where sum[i:j] = target. We know that sum[i:j] = A[i] + A[i+1] +... + A[j].
Then we also know that
Let's define prefixSum[j] = A[0] + A[1] + ... + A[j] 0 <= j <= n-1 (n = A.length)
It is easy to see that,
sum[i:j] = A[i] + A[i+1] ... + A[j] =
(A[0] + A[1] + ... A[i] ... + A[j]) - (A[0] + A[1] + ... A[i-1]) =
prefix[j] - prefix[i-1].

Now we the problem reduces to finding # of pairs (i, j) (i < j) such that
prefix[j] - prefix[i-1] = target
This becomes prefix[i-1] = prefix[j] - target with some algebra.
So we use the hashmap to find all pairs that satisfy the above equations.

We only need to track the prefix sum up to this point however, since we already saved all the previous results in the map.

if (sum == target) total++ Here I am checking for the case where the current element is equal to the sum (it needs no interval to produce the sum).
     */

    static int genericPrefixSum(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int pSum = 0;
        int result = 0;
        map.put(0, 1);
        for (int i = 0; i < arr.length; i++) {
            pSum += arr[i];
            result += map.getOrDefault(pSum - k, 0);
            map.put(pSum, map.getOrDefault(pSum, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(genericPrefixSum(new int[]{1, 0, 1, 0, 1}, 2));
    }
}
