package com.ctci.tree;

public class DiameterTree {

    // diameter = lh + rh (max path for a tree)
    static int diameter = 0;

    public static void main(String[] args) {
        Node root  = new Node(1);
        root.left  = new Node(12);
        root.right = new Node(13);

        root.right.left   = new Node(14);
        root.right.right  = new Node(15);

        root.right.left.left   = new Node(21);
        root.right.left.right  = new Node(22);
        root.right.right.left  = new Node(23);
        root.right.right.right = new Node(24);

        postOrderHeight(root);
        System.out.println("Diameter is: "+diameter);
    }

    public static int postOrderHeight(Node node){
        if(node==null){
            return 0;
        }
        int lh = postOrderHeight(node.left);
        int rh = postOrderHeight(node.right);
        int dia = lh+rh;
        diameter = Math.max(dia,diameter);
        return Math.max(lh,rh) + 1;
    }
}
