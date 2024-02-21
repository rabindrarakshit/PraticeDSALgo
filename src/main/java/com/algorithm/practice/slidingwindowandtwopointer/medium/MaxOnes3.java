package com.algorithm.practice.slidingwindowandtwopointer.medium;

// Ref: https://leetcode.com/problems/max-consecutive-ones-iii/description/

public class MaxOnes3 {

    // Time: O(N)
    // Space: O(1)
    static int maxOnes(int[] arr, int k) {
        int left = 0, right = 0;
        for (right = 0; right < arr.length; right++) {
            if(arr[right]==0){
                k--;
            }
            // When k is less than 0 it means we have more zeroes than given, so of course we cannot consider the new
            // length we just stay constant by increasing both ends left and right. But we keep reducing K each time
            // we see a zero. Now if the left sees a zero then we increment it. The zero balance is important because
            // if we find a range of 1's after these zeroes. As soon as zero count is >=0 we stop increasing left
            // index and hence the length increases
            if(k<0 && arr[left++]==0){
                k++;
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        System.out.println(maxOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
    }
}