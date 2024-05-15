package com.algorithm.practice.graph.striver.mst;

public class NumberOfOpsToConnectNetworks {
    static int numberOfOps(int[][] graph, int node){
        DisjointSetsUnionBySize disjointSet = new DisjointSetsUnionBySize(node);
        int extraEdges = 0;
        for(int i=0;i<graph.length;i++){
            int u = graph[i][0];
            int v = graph[i][1];

            if(disjointSet.findParent(u)==disjointSet.findParent(v)){
                extraEdges++;
            }else {
                disjointSet.unionBySize(u,v);
            }
        }
        int components =0;
        for(int i=0;i<node;i++){
            if(disjointSet.parent.get(i)==i){
                components++;
            }
        }

        if(components-1<=extraEdges){
            return components-1;
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        int V = 9;
        int[][] edge = {{0, 1}, {0, 2}, {0, 3}, {1, 2}, {2, 3}, {4, 5}, {5, 6}, {7, 8}};
        System.out.println(numberOfOps(edge,V));
    }
}
