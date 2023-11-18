package com.ctci.tree.medium;

import com.ctci.tree.Node;

public class IsTreeBalanced {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(12);
        root.right = new Node(13);

    /*    root.right.left   = new Node(14);
        root.right.right  = new Node(15);

        root.right.left.left   = new Node(21);
        root.right.left.right  = new Node(22);
        root.right.right.left  = new Node(23);
        root.right.right.right = new Node(24);
        */
        if (dfsHeight(root) == -1) {
            System.out.println("Not Balanced!");
        } else {
            System.out.println("Balanced!");
        }

    }

    public static int dfsHeight(Node node) {
        if (node == null) {
            return 0;
        }
        int lh = dfsHeight(node.left);
        if (lh == -1) {
            return -1;
        }
        int rh = dfsHeight(node.right);
        if (rh == -1) {
            return -1;
        }
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }
        return Math.max(lh, rh) + 1;
    }
}
