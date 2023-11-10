package com.ctci.graph.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Graph {
    ArrayList<Project> projects = new ArrayList<>()   ;
    Map<String, Project> map = new HashMap<>();


    public Project getOrCreateProject(String name){
        if(map.containsKey(name))
            return map.get(name);
        Project project = new Project(name);
        projects.add(project);
        map.put(name, project);
        return map.get(name);
    }

    public void addEdge(String start, String end){
        Project p1 = getOrCreateProject(start);
        Project p2 = getOrCreateProject(end);
        p1.addNeighbour(p2);
    }

    public ArrayList<Project> getNodes(){
        return projects;
    }
}
