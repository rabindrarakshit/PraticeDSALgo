package com.algorithm.practice.bst.algoexpert;

public class TestBST {

    public static void main(String[] args) {
        BST bst = new BST(5);
        bst.insert(6);
        bst.insert(7);
        bst.insert(8);
        bst.insert(9);
        System.out.println();
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        public BST insert(int value) {
            if(this==null){
                return new BST(value);
            }
            BST current = this;
            while(current!=null){
                if(current.value<=value){
                    if(current.right!=null){
                        current = current.right;
                    }else{
                        current.right = new BST(value);
                        break;
                    }
                }else{
                    if(current.left!=null){
                        current = current.left;
                    }else{
                        current.left = new BST(value);
                        break;
                    }
                }
            }
            return this;
        }

        public boolean contains(int value) {
            BST current = this;
            while(current!=null){
                if(current.value==value){
                    return true;
                }else if(current.value<value){
                    current = current.right;
                }else{
                    current = current.left;
                }
            }
            return false;
        }

        public BST remove(int value) {
            if(this==null)
                return this;
            if(this.left==null && this.right==null)
                return this;
            if(this.value==value){
                return helper(this);
            }
            BST dummy = this;
            BST root = this;
            while(root!=null){
                if(root.value<value){
                    if(root.right!=null && root.right.value==value){
                        root.right = helper(root.right);
                    }else{
                        root = root.right;
                    }
                }else{
                    if(this.left!=null && this.left.value==value){
                        root.left = helper(root.left);
                    }else{
                        root = root.left;
                    }
                }
            }
            return dummy;
        }

        public BST helper(BST node){
            if(node.left==null){
                return node.right;
            }
            else if(node.right==null){
                return node.left;
            }
            else{
                BST rightNode = node.right;
                BST leftLeave = findLeftLeave(node.left);
                leftLeave.right= rightNode;
                return node.left;
            }
        }

        public BST findLeftLeave(BST node){
            while(node.right!=null){
                node = node.right;
            }
            return node;
        }
    }
}
