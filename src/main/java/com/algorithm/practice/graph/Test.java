package com.algorithm.practice.graph;

import java.util.ArrayList;

public class Test {

    static class Edge {
        int src;
        int dest;
        int wt;

        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }

    public static void main(String[] args) {
        System.out.println("Rabindra");
        int v = 4; // size of graph, no of vertices
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        //print 2's neighbours
        for(int i=0; i<graph[2].size();i++){
            Edge e = graph[2].get(i);
            System.out.print(e.dest+ " ");
        }

    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2, 2));

        graph[1].add(new Edge(1,2, 10));
        graph[1].add(new Edge(1,3, 0));

        graph[2].add(new Edge(2,3, -1));
        graph[2].add(new Edge(2,1, 10));
        graph[2].add(new Edge(2,0, 2));

        graph[3].add(new Edge(3,2, -1));
        graph[3].add(new Edge(3,1, 0));

    }
}
