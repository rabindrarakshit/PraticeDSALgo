package com.algorithm.practice.graph.striver.mst;

import java.util.ArrayList;
import java.util.List;

// Ref: https://takeuforward.org/graph/number-of-islands-ii-online-queries-dsu-g-51/
/*
* Time Complexity: O(Q*4α) ~ O(Q) where Q = no. of queries. The term 4α is so small that it can be considered constant.

Space Complexity: O(Q) + O(N*M) + O(N*M), where Q = no. of queries, N = total no. of rows, M = total no. of columns.
* The last two terms are for the parent and the size array used inside the Disjoint set data structure. The first term is to store the answer.
*
* */

public class NumberOfIsland2 {
    static boolean isValid(int adjr, int adjc, int n, int m) {
        return adjr >= 0 && adjr < n && adjc >= 0 && adjc < m;
    }

    static List<Integer> numberOfIslands(int n, int m, int[][] operators) {
        DisjointSetsUnionBySize ds = new DisjointSetsUnionBySize(n * m);
        int visited[][] = new int[n][m];
        int cnt = 0;
        List<Integer> result = new ArrayList<>();
        int len = operators.length;

        for (int i = 0; i < operators.length; i++) {
            int row = operators[i][0];
            int col = operators[i][1];
            if (visited[row][col] == 1) {
                result.add(cnt);
                continue;
            }
            visited[row][col] = 1;
            cnt++;

            int boundaryRows[] = {0, -1, 0, 1};
            int boundaryCols[] = {-1, 0, 1, 0};

            for (int ind = 0; ind <= 3; ind++) {
                int adjR = boundaryRows[ind] + row;
                int adjC = boundaryCols[ind] + col;
                if (isValid(adjR, adjC, n, m)) {
                    if (visited[adjR][adjC] == 1) {
                        int node = row * m + col;
                        int adjNode = adjR * m + adjC;
                        if (ds.findParent(node) != ds.findParent(adjNode)) {
                            cnt--;
                            ds.unionBySize(node, adjNode);
                        }
                    }
                }
            }
            result.add(cnt);
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 4, m = 5;
        int[][] operators = {{0, 0}, {0, 0}, {1, 1}, {1, 0}, {0, 1},
                {0, 3}, {1, 3}, {0, 4}, {3, 2}, {2, 2}, {1, 2}, {0, 2}
        };


        List<Integer> ans = numberOfIslands(n, m, operators);

        int sz = ans.size();
        for (int i = 0; i < sz; i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("");
    }
}
