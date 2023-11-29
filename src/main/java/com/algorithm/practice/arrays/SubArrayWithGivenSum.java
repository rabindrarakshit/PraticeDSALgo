package com.algorithm.practice.arrays;

public class SubArrayWithGivenSum {

    //Brute Force
    static void subArraySum(int[] arr, int n, int sum)
    {
       for(int i=0; i<n;i++){
           int curr_sum = arr[i];
           if(curr_sum == sum){
               System.out.println("Found the sum at index: "+i);
               return;
           }
           for(int j=i+1; j<n; j++){
                curr_sum = curr_sum + arr[j];
               if(curr_sum == sum){
                   System.out.println("Found the sum between index: "+i+ " and "+j);
                   return;
               }
               if(curr_sum>sum){
                   break;
               }
           }
       }
        System.out.println("Not found!!");
    }

    static void optimizedSubArraySum(int[] arr, int n, int sum){
        int curr_sum=arr[0], start=0;
        for(int i=1; i<=n;i++){
            while (curr_sum>sum && start<i-1){
                curr_sum= curr_sum - arr[start];
                start++;
            }
            if(curr_sum==sum){
                System.out.println("Found between index: "+start+" and "+ (i-1));
                return;
            }
            if(i<n){
                curr_sum= curr_sum+arr[i];
            }
        }
        System.out.println("Not found!!");
    }

    public static void main(String[] args) {
        optimizedSubArraySum(new int[]{1,2,3,5}, 4, 8);
    }
}
