package com.algorithm.practice.bst;

import com.algorithm.practice.tree.Node;

class NodeValue {
    public int maxValue, minValue, maxSize;

    NodeValue(int minValue, int maxValue, int maxSize) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.maxSize = maxSize;
    }
}

public class LargestBSTInBT {
    static NodeValue largestBST(Node node) {
        if (node == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        NodeValue left = largestBST(node.left);
        NodeValue right = largestBST(node.right);

        if (node.data > left.maxValue && node.data < right.minValue) {
            return new NodeValue(Math.min(node.data, left.minValue), Math.max(node.data, right.maxValue),
                    left.maxSize + right.maxSize + 1);
        }
        return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(11);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);

        System.out.println(largestBST(root).maxSize);
    }
}
