package com.ctci.tree;

class BinaryTreeHeight {
    static int height(Node node){
        if(node==null)
            return 0;
        else{
            int lh= height(node.left);
            int rh = height(node.right);
            return 1 + Math.max(lh, rh);
        }
    }

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

        System.out.println("Height(Depth) of tree is: "+height(root));
    }
}

