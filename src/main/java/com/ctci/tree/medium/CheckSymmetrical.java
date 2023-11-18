package com.ctci.tree.medium;

import com.ctci.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class CheckSymmetrical {


    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(10);

        root.right = new Node(2);
        root.right.left = new Node(4);
        root.right.right = new Node(10);
        System.out.println(checkSymmetrical(root));
    }

    /********* Solution1 ***********/

    static boolean isSymmetricUtil(Node  root1, Node  root2) {
        if (root1 == null || root2 == null)
            return root1 == root2;
        return (root1 . data == root2 . data) && isSymmetricUtil(root1 . left, root2 .
                right) && isSymmetricUtil(root1 . right, root2 . left);
    }

    static boolean isSymmetric(Node  root) {
        if (root==null) return true;
        return isSymmetricUtil(root . left, root . right);
    }

    /******** Solution 2 *************/

    public static boolean checkSymmetrical(Node node) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        if (node.left == null || node.right == null) {
            return false;
        }
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        getLeftPreOrder(node.left, leftList);
        getRightPreOrder(node.right, rightList);
        return leftList.equals(rightList);
    }

    public static void getLeftPreOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.data);
        getLeftPreOrder(node.left, list);
        getLeftPreOrder(node.right, list);
    }

    public static void getRightPreOrder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.data);
        getRightPreOrder(node.right, list);
        getRightPreOrder(node.left, list);
    }
}
