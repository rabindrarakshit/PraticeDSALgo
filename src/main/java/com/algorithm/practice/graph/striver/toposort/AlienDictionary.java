package com.algorithm.practice.graph.striver.toposort;

// Ref: https://takeuforward.org/data-structure/alien-dictionary-topological-sort-g-26/
/*
Time Complexity: O(N*len)+O(K+E), where N is the number of words in the dictionary,
‘len’ is the length up to the index where the first inequality occurs, K = no. of nodes, and E = no. of edges.

Space Complexity: O(K) + O(K)+O(K)+O(K) ~ O(4K), O(K) for the indegree array, and O(K) for the queue data structure
 used in BFS(where K = no.of nodes), O(K) for the answer array and O(K) for the adjacency list used in the algorithm.
* */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictionary {
    static String sortedLetters(String[] words, int letters) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < letters; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < words.length - 1; i++) {
            int min = Math.min(words[i].length(), words[i + 1].length());
            for (int j = 0; j < min; j++) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    adjList.get(words[i].charAt(j) - 'a').add(words[i + 1].charAt(j) - 'a');
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : topo(adjList)) {
            sb.append((char) ('a' + i));
        }
        return sb.toString();
    }

    static List<Integer> topo(List<List<Integer>> adjList) {
        int[] inbounds = new int[adjList.size()];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < adjList.size(); i++) {
            for (Integer adjNode : adjList.get(i)) {
                inbounds[adjNode]++;
            }
        }

        for (int i = 0; i < adjList.size(); i++) {
            if (inbounds[i] == 0) {
                q.add(i);
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            Integer node = q.poll();
            ans.add(node);
            for (Integer adjNode : adjList.get(node)) {
                inbounds[adjNode]--;
                if (inbounds[adjNode] == 0) {
                    q.add(adjNode);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        String ans = sortedLetters(dict, K);

        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println("");
    }
}
