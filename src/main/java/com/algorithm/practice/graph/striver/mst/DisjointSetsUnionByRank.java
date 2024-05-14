package com.algorithm.practice.graph.striver.mst;

// Ref: https://takeuforward.org/data-structure/disjoint-set-union-by-rank-union-by-size-path-compression-g-46/
// Time Complexity:  The time complexity is O(4) which is very small and close to 1. So, we can consider 4 as a constant.
import java.util.ArrayList;
import java.util.List;

public class DisjointSetsUnionByRank {
    static List<Integer> rank = new ArrayList<>();
    static List<Integer> parent = new ArrayList<>();

    DisjointSetsUnionByRank(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public static int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        parent.set(node, findParent(parent.get(node)));
        return parent.get(node);
    }

    static void unionByRank(int u, int v) {
        int up = findParent(u);
        int vp = findParent(v);

        if (rank.get(up) < rank.get(vp)) {
            parent.set(up, vp);
        } else if (rank.get(up) > rank.get(vp)) {
            parent.set(vp, up);
        } else {
            parent.set(vp, up);
            rank.set(up, rank.get(up) + 1);
        }
    }

}

class Main {
    public static void main(String[] args) {
        DisjointSetsUnionByRank ds = new DisjointSetsUnionByRank(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}
