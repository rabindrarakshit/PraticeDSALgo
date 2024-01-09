package com.algorithm.practice.arrays.medium;

public class
MaximumSubArrayKadane {

    //Kadane's Algo with indices
    static int maxSubArrayKadane(int[] arr){
        int max_ending_here = Integer.MIN_VALUE;
        int max_so_far = 0;
        int start = 0, end = 0, s = 0;
        for(int i=0; i<arr.length; i++){
            max_ending_here = max_ending_here +arr[i];
            if(max_ending_here>max_so_far){
                max_so_far = max_ending_here;
                end = i;
            }
            if(max_ending_here<0){
                max_ending_here = 0;
                start = i+1;
            }
        }
        System.out.println("Start: "+ start + " End: "+ end);
        return max_so_far;
    }

    // For all negatives
    static int maxSubArray(int[] arr){
        int curr_max = arr[0];
        int max_sum = arr[0];

        for(int i=1; i<arr.length; i++){
            curr_max = Math.max(arr[i], curr_max+arr[i]);
            max_sum = Math.max(curr_max, max_sum);
        }
        return max_sum;
    }

    public static void main(String[] args) {
    //    System.out.println(maxSubArrayKadane(new int[]{-5,-2,-3,-1}));
        System.out.println(maxSubArrayKadane(new int[]{1,2,3,-4,4,5}));
    }
}
