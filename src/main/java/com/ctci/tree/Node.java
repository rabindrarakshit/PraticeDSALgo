package com.ctci.tree;

public class Node {
    public int data;
    public Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }

    @Override
    public boolean equals(Object n2) {
        return this.left.equals(((Node) n2).left) &&
                this.right.equals(((Node) n2).right) &&
                this.data == ((Node) n2).data;
    }
}
