package com.algorithm.practice.bst;

/*
 * Brute Force: We do an inorder traversal which generates a sorted list. Then we store it and do a naive two sum.
 * One pointer going from the front and one from the back. if the sum is less, then we increase the front pointer
 * and if the sum is more, then we decrease the back pointer.
 * Time Complexity: O(n)-> for traversing+O(n)->for finding the elements
 * Space Complexity: O(n) -> storing the inorder traversal
 *
 * Optimized Approach: That we do here below
 * We use the BSTIterator to traverse from front and back.
 *
 * Time Complexity: O(n)
 * Space Complexity: 2*O(h)
 * */

import com.algorithm.practice.tree.Node;

public class TwoSumBST {
    static boolean findTargetElements(Node node, int k) {
        BSTIterator bstIterator = new BSTIterator(node, false);
        BSTIterator reverseBstIterator = new BSTIterator(node, true);

        int front = bstIterator.next().data;
        int back = reverseBstIterator.next().data;

        while (front < back) {
            if (front + back == k) {
                return true;
            } else if (front + back < k) {
                front = bstIterator.next().data;
            } else {
                back = reverseBstIterator.next().data;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);

        System.out.println(findTargetElements(root, 28));
        System.out.println(findTargetElements(root, 50));
    }
}
