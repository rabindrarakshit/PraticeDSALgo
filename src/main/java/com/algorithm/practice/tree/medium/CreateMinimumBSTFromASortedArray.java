package com.algorithm.practice.tree.medium;

import com.algorithm.practice.tree.Node;

public class CreateMinimumBSTFromASortedArray {
    public static Node createMinimumBST(int[] arr, int start, int end){
        if(end<start){
            return null;
        }
        int mid = start + (end-start)/2;
        Node n = new Node(arr[mid]);
        n.left = createMinimumBST(arr, start, mid-1);
        n.right = createMinimumBST(arr, mid+1, end);
        return n;
    }

    public static void main(String[] args) {
        Node root = createMinimumBST(new int[]{1,2,3,4,5,6}, 0, 5);
        System.out.println("Done!!");
    }
}
