package com.algorithm.practice;

import com.algorithm.practice.tree.Node;

import java.util.HashMap;
import java.util.Map;

public class Test {
    static int max = 0;

    public static void main(String[] args) {
        Node node = new Node(3);
        Node left = new Node(1);
        Node right = new Node(2);
        node.left = left;
        node.right = right;
        Node layer2left = new Node(4);
        Node layer2right = new Node(5);
        left.left = layer2left;
        left.right = layer2right;
        Node layer3left = new Node(6);
        layer2left.left = layer3left;
        Node layer4left = new Node(7);
        layer3left.left = layer4left;
        Node layer5left = new Node(8);
        layer4left.left = layer5left;
        Node layer3right = new Node(9);
        right.right = layer3right;


        Node node2 = new Node(3);
        Node left2 = new Node(1);
        Node right2 = new Node(2);
        node2.left = left2;
        node2.right = right2;
        Node layer2left2 = new Node(4);
        Node layer2right2 = new Node(5);
        left2.left = layer2left2;
        left2.right = layer2right2;
        Node layer3left2 = new Node(6);
        layer2left2.left = layer3left;
        Node layer4left2 = new Node(7);
        layer3left2.left = layer4left;
        Node layer5left2 = new Node(8);
        layer4left2.left = layer5left;
        Node layer3right2 = new Node(9);
        right2.right = layer3right2;

        System.out.println(checkSimilar(node, node2));

        Map<Integer,Integer> map = new HashMap<>();
        map.put(-1,1);
    }

    public static int height(Node node) {
        if (node == null) {
            return 0;
        }
        int lh = height(node.left);
        int rh = height(node.right);
        max = Math.max(max, lh + rh + node.data);
        return Math.max(lh, rh) + node.data;
    }



    public static boolean checkSimilar(Node node1, Node node2) {
        boolean flag = true;
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return node1.data == node2.data &&
                checkSimilar(node1.left, node2.left) &&
                checkSimilar(node1.right, node2.right);
    }


    // Pre Order : Root -> Left -> Right
    // In Order : Left -> Root -> Right
    // Post Order : Left -> Right -> Root
    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

    static void inOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            System.out.println(node.data);
            postOrder(node.right);
        }
    }

}
