package com.algorithm.practice.graph.topologicalsort;

import java.util.ArrayList;
import java.util.Stack;

public class Question {
    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        String[][] dependencies = {
                {"a", "b"},
                {"b", "c"},
                {"a", "c"},
                {"d", "e"},
                {"b", "d"},
                {"e", "f"},
                {"a", "f"},
                {"h", "i"},
                {"h", "j"},
                {"i", "j"},
                {"g", "j"}};
        findBuilderOrder(dependencies).forEach(project -> System.out.println(project.name));

    }

    public static Stack<Project> findBuilderOrder(String[][] dependencies) {
        Graph graph = buildGraph(dependencies);
        return orderGraph(graph.getNodes());
    }

    public static Graph buildGraph(String[][] dependencies) {
        Graph graph = new Graph();
        for (String[] dependency : dependencies) {
            graph.addEdge(dependency[0], dependency[1]);
        }
        return graph;
    }

    public static Stack<Project> orderGraph(ArrayList<Project> projects) {
        Stack<Project> stack = new Stack<>();
        for (Project project : projects) {
            if (project.getState() == Project.State.BLANK) {
                if (!doDFS(project, stack)) {
                    return null;
                }
            }
        }
        return stack;
    }

    public static boolean doDFS(Project project, Stack<Project> stack) {
        if (project.getState() == Project.State.PARTIAL) {
            return false;
        }
        if (project.getState() == Project.State.BLANK) {
            project.setState(Project.State.PARTIAL);
            for (Project child : project.getChildren()) {
                if (!doDFS(child, stack)) {
                    return false;
                }
            }
            project.setState(Project.State.COMPLETE);
            stack.push(project);
        }
        return true;
    }


}
