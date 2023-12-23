package com.algorithm.practice.bst;

import com.algorithm.practice.tree.Node;

import java.util.Stack;


/*
 * in-order traversal of a binary search tree (BST)
 *
 * Here if reverse is true, then it will be right->node->left. Hence it will be reverse sorted.
 *
 * Time Complexity: O(1) - This is average time complexity
 * Explanation: There are n next calls and at max we will be pushing n elements in the stack so n/n ~ 1
 * Space Complexity: O(h)
 * */

class BSTIterator {
    Stack<Node> stack = new Stack<>();
    boolean reverse;

    public BSTIterator(Node node, boolean isReverse) {
        reverse = isReverse;
        pushNode(node);
    }

    void pushNode(Node node) {
        while (node != null) {
            stack.push(node);
            if (reverse) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
    }

    public Node next() {
        Node node = null;
        if (!stack.isEmpty()) {
            node = stack.pop();
            if (reverse && node.left != null) {
                pushNode(node.left);
            } else {
                if (node.right != null) {
                    pushNode(node.right);
                }
            }
        }
        return node;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

public class BSTIteratorUtil {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);

        BSTIterator bstIterator = new BSTIterator(root, false);
        System.out.println(bstIterator.next().data);
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next().data);
        System.out.println(bstIterator.next().data);
        System.out.println(bstIterator.next().data);

    }

}
