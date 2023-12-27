package com.algorithm.practice.tree.traversal;

import com.algorithm.practice.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Pair{
    Node node;
    int num;

    Pair(Node node, int num){
        this.node = node;
        this.num = num;
    }
}

public class AllOrderOneTravese {

    public static void allTraversal(Node node, List<Node> pre, List<Node> post, List<Node> in){
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(node, 1));
        while(!stack.isEmpty()){
            Pair p = stack.pop();
            if(p.num==1){
                pre.add(p.node);
                p.num++;
                stack.push(p);
                if(p.node.left!=null){
                    stack.push(new Pair(p.node.left, 1));
                }
            } else if (p.num==2) {
                in.add(p.node);
                p.num++;
                stack.push(p);
                if(p.node.right!=null){
                    stack.push(new Pair(p.node.right, 1));
                }
            } else{
                post.add(p.node);
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(14);

        root.right.left = new Node(13);
        root.right.right = new Node(15);

        List<Node> pre = new ArrayList<>();
        List<Node> post = new ArrayList<>();
        List<Node> in = new ArrayList<>();

        allTraversal(root, pre, post, in);
        pre.forEach(n-> System.out.print(n.data+" "));
        System.out.println();
        in.forEach(n-> System.out.print(n.data+" "));
        System.out.println();
        post.forEach(n-> System.out.print(n.data+" "));
    }
}
