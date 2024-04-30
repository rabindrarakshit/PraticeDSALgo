package com.algorithm.practice.graph.striver.toposort;

// Ref: https://takeuforward.org/data-structure/course-schedule-i-and-ii-pre-requisite-tasks-topological-sort-g-24/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* Here the input will be A->B which says A can be completed after B.
* Now in Kahn we operate with inbounds, which represents the correct sequence in which it can be done. So the Graph we need
* to create for Kahn would be:
* B -> A which says inbound for B is 0 and for A is 1.
* */


public class CourseScheduleOne {
    static Integer[] courseSchedule(List<List<Integer>> adjList) {
        int[] inbound = new int[adjList.size()];
        Queue<Integer> q = new LinkedList<>();

        // Create Inbound Array
        for (int i = 0; i < adjList.size(); i++) {
            List<Integer> list = adjList.get(i);
            for (Integer adjNode : list) {
                inbound[adjNode]++;
            }
        }

        for (int i = 0; i < inbound.length; i++) {
            if (inbound[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        Integer[] ans = new Integer[adjList.size()];
        while (!q.isEmpty()) {
            Integer node = q.poll();
            ans[count++] = node;
            for (Integer adjNode : adjList.get(node)) {
                inbound[adjNode]--;
                if (inbound[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }

        if (count == adjList.size())
            return ans;
        else
            return new Integer[]{};
    }

    static List<List<Integer>> createDependencyGraph(List<List<Integer>> adjList) {
        List<List<Integer>> dependencyGraph = new ArrayList<>();
        for (int i = 0; i < adjList.size(); i++) {
            dependencyGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < adjList.size(); i++) {
            for (Integer adjNode : adjList.get(i)) {
                dependencyGraph.get(adjNode).add(i);
            }
        }

        return dependencyGraph;
    }

    static List<List<Integer>> createDependencyGraph(int[][] arr) {
        List<List<Integer>> dependencyGraph = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            dependencyGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < arr.length; i++) {
            dependencyGraph.get(arr[i][1]).add(arr[i][0]);
        }

        return dependencyGraph;
    }

    public static void main(String[] args) {
        int N = 4;
        int M = 3;
        List<List<Integer>> prerequisites = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            prerequisites.add(i, new ArrayList<>());
        }

        prerequisites.get(0).add(1);

        prerequisites.get(1).add(2);

        prerequisites.get(2).add(3);

        // prerequisites.get(3).add(0);

        Integer[] ans = courseSchedule(createDependencyGraph(prerequisites));

        for (int task : ans) {
            System.out.print(task + " ");
        }
        System.out.println("");
    }
}
