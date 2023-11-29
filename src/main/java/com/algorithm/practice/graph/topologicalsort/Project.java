package com.algorithm.practice.graph.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Project {
    public enum State {BLANK, PARTIAL, COMPLETE}

    private Map<String, Project> map = new HashMap<>();
    ArrayList<Project> children = new ArrayList<>();
    String name;
    private State state = State.BLANK;

    Project(String name) {
        this.name = name;
    }

    public void addNeighbour(Project node) {
        if (!map.containsKey(node.getName())) {
            children.add(node);
            map.put(node.getName(), node);
        }
    }

    public ArrayList<Project> getChildren() {
        return children;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    public String getName() {
        return name;
    }

}
