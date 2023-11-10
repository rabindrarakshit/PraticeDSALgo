package com.ctci.tree;

public class BoundaryTraversal {
    public static void main(String[] args) {
        Node node = new Node(1);
        printBoundary(node);
    }

    public static void printBoundary(Node node){
        printLeaves(node);
    }

    public static void printLeaves(Node node){}
    public static void printLeftBoundary(Node node){}
    public static void printRightBoundary(Node node){}

}
