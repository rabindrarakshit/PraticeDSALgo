package com.algorithm.practice.dynamicprogramming.subsequence;

// Ref: https://takeuforward.org/data-structure/count-partitions-with-given-difference-dp-18/

public class CountPartitionsWithDiffK {

    /*
    * This question is a slight modification of the problem discussed in Count Subsets with Sum K.

We have the following two conditions given to us.

S1 + S2 = D   – (i)

S1 >= S2     – (ii)

 If we calculate the total sum of elements of the array (say totSum), we can say that,

S1 = totSum – S2      – (iii)

Now solving for equations (i) and (iii), we can say that

S2 = (totSum – D)/2    – (iv)

Therefore the question “Count Partitions with a difference D” is modified to “Count Number of subsets with sum (totSum – D)/2 ”. This is exactly what we had discussed in the article  Count Subsets with Sum K.

Edge Cases:

The following edge cases need to be handled:

As the array elements are positive integers including zero, we don’t want to find the case when S2 is negative or we can say that totSum is lesser than D, therefore if totSum<D, we simply return 0.
S2 can’t be a fraction, as all elements are integers, therefore if totSum – D is odd, we can return 0.
From here on we will discuss the approach to “Count Subsets with Sum K” with the required modifications. Moreover, as the array elements can also contain 0, we will handle it as discussed in part-1 of this article.*/

    static int mod = (int) (Math.pow(10, 9) + 7);

    static int findWays(int[] num, int tar) {
        int n = num.length;

        int dp[][] = new int[n][tar + 1];

        if (num[0] == 0) dp[0][0] = 2;  // 2 cases -pick and not pick
        else dp[0][0] = 1;  // 1 case - not pick

        if (num[0] != 0 && num[0] <= tar) dp[0][num[0]] = 1;  // 1 case -pick

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= tar; target++) {

                int notTaken = dp[ind - 1][target];

                int taken = 0;
                if (num[ind] <= target)
                    taken = dp[ind - 1][target - num[ind]];

                dp[ind][target] = (notTaken + taken) % mod;
            }
        }
        return dp[n - 1][tar];
    }

    static int countPartitions(int n, int d, int[] arr) {
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }

        //Checking for edge cases
        if (totSum - d < 0 || (totSum - d) % 2 == 1) return 0;

        return findWays(arr, (totSum - d) / 2);
    }


    public static void main(String args[]) {

        int arr[] = {5, 2, 6, 4};
        int n = arr.length;
        int d = 3;

        System.out.println("The number of subsets found are " + countPartitions(n, d, arr));
    }
}
