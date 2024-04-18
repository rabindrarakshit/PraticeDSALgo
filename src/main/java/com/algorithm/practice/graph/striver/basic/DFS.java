package com.algorithm.practice.graph.striver.basic;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    static void dfs(List<List<Integer>> adjList, boolean[] visited, int node, List<Integer> ls) {
        //marking current node as visited
        visited[node] = true;
        ls.add(node);
        for (int i : adjList.get(node)) {
            if (!visited[i])
                dfs(adjList, visited, i, ls);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 2; i++) {
            list.add(new ArrayList<>());
        }
        list.get(0).add(1);
        list.get(0).add(2);

        list.get(1).add(2);
        list.get(1).add(0);

        list.get(2).add(1);
        list.get(2).add(0);

        boolean[] visited = new boolean[3];
        List<Integer> res = new ArrayList<>();
        dfs(list, visited, 0,res);
        for(int i : res)
            System.out.println(i);
    }
}
