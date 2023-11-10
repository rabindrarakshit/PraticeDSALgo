package com.ctci.tree;

import java.util.ArrayList;
import java.util.List;

public class Inorder {
    static List<Integer> result = new ArrayList<>();
    static List<Integer> inOrder(Node node){
        if(node.left!=null)
            inOrder(node.left);
        result.add(node.data);
        if(node.right!=null){
            inOrder(node.right);
        }
        return  result;
    }
}
