package com.algorithm.practice.graph.basic;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int value;
    public List<GraphNode> adjacents;
    public State state;

    public GraphNode(int value) {
        this.value = value;
        adjacents = new ArrayList<>();
        state = State.UnVisited;
    }
}
