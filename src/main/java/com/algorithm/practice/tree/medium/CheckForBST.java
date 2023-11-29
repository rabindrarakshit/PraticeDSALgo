
package com.algorithm.practice.tree.medium;

import com.algorithm.practice.tree.Node;

// need to complete/check
public class CheckForBST {
    boolean isLeaf(Node node) {
        if (node != null && node.left == null && node.right == null) {
            return true;
        }
        return false;
    }

    boolean checkForBST(Node node) {
        if (node!=null){
            if(!isLeaf(node.left))
                checkForBST(node.left);
            if(!isLeaf(node.right))
                checkForBST(node.right);

        }
        return false;
    }
}
