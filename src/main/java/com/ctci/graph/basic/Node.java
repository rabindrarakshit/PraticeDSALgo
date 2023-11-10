package com.ctci.graph.basic;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int value;
    public boolean visited;
    public List<Node> adjacent;

    public Node(int value) {
        this.value = value;
        this.visited = false;
        adjacent = new ArrayList<>();
    }
}