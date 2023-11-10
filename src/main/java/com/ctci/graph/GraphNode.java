package com.ctci.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    int value;
    List<GraphNode> adjacents;
    State state;

    GraphNode(int value) {
        this.value = value;
        adjacents = new ArrayList<>();
        state = State.UnVisited;
    }
}
