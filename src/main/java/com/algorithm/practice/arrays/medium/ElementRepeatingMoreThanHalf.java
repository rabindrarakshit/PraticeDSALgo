package com.algorithm.practice.arrays.medium;

// Below algo is called Moore's Voting Algo

public class ElementRepeatingMoreThanHalf {
    static int mooresVotingAlgo(int[] arr) {
        int count = 0;
        int element = -1;

        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                element = arr[i];
                count = 1;
            } else if (element == arr[i]) {
                count++;
            } else if (element != arr[i]) {
                count--;
            }
        }

        // we can straight away return the element if the problem mentions there will be one element which satisfies the criteria
        // however if it's not mentioned then we do the below check
        // return element;

        //checking if the stored element
        // is the majority element:
        int cnt1 = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) cnt1++;
        }

        if (cnt1 > (arr.length / 2)) return element;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(mooresVotingAlgo(new int[]{1, 2, 1, 1, 1, 2}));
    }
}
