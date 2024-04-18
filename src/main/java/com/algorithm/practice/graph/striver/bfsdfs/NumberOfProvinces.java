package com.algorithm.practice.graph.striver.bfsdfs;

import java.util.ArrayList;
import java.util.List;

//Ref: https://takeuforward.org/data-structure/number-of-provinces/

/*
Time Complexity: O(N) + O(V+2E), Where O(N) is for outer loop and inner loop runs in total a single DFS over entire graph, and we know DFS takes a time of O(V+2E).

Space Complexity: O(N) + O(N),Space for recursion stack space and visited array.
 */

public class NumberOfProvinces {
    static int numberOfProvinces(List<List<Integer>> list, boolean[] visited, int node) {
        int count = 0;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(list, visited, i);
            }
        }
        return count;
    }

    static void dfs(List<List<Integer>> adjList, boolean[] visited, int node) {
        //marking current node as visited
        visited[node] = true;
        for (int i : adjList.get(node)) {
            if (!visited[i])
                dfs(adjList, visited, i);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        int size = 6;
        boolean[] visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            list.add(new ArrayList<>());
        }

        list.get(0).add(1);
        list.get(1).add(2);
        list.get(3).add(4);

        System.out.println(numberOfProvinces(list, visited, 0));
    }
}
