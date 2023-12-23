package com.algorithm.practice.bst;

import com.algorithm.practice.tree.Node;

/*
Time Complexity: Here each node gets traversed three times at max in the worst case so the time complexity is
O(3N) which is same as O(N)

Space Complexity: Recursion Stack Space : O(1)

We are able to do this only because the input is a preorder of BST. If it was random then we need to do brute insert.
 */

public class BSTFromPreOrder {
    static Node bstFromPreOrder(int[] A) {
        return bstFromPreOrder(A, Integer.MAX_VALUE, new int[]{0});
    }

    static Node bstFromPreOrder(int[] A, int bound, int[] count) {
        if (count[0] >= A.length || A[count[0]] >= bound) {
            return null;
        }
        Node node = new Node(A[count[0]++]);
        node.left = bstFromPreOrder(A, node.data, count);
        node.right = bstFromPreOrder(A, bound, count);
        return node;
    }

    public static void main(String[] args) {
        Node root = bstFromPreOrder(new int[]{8, 5, 1, 7, 10, 12});
        System.out.println(root.data);
    }
}
