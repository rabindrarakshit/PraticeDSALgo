package com.algorithm.practice.graph.striver.mst;

import java.util.ArrayList;
import java.util.List;

// Ref: https://takeuforward.org/data-structure/disjoint-set-union-by-rank-union-by-size-path-compression-g-46/
// Time Complexity:  The time complexity is O(4) which is very small and close to 1. So, we can consider 4 as a constant.
public class DisjointSetsUnionBySize {
    static List<Integer> rank = new ArrayList<>();
    static List<Integer> parent = new ArrayList<>();
    static List<Integer> size = new ArrayList<>();

    DisjointSetsUnionBySize(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        parent.set(node, findParent(parent.get(node)));
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int up = findParent(u);
        int vp = findParent(v);
        if (up == vp) return;
        if (size.get(up) < size.get(vp)) {
            parent.set(up, vp);
            size.set(up, size.get(vp) + size.get(up));
        } else {
            parent.set(vp, up);
            size.set(up, size.get(up) + size.get(vp));
        }
    }

}

class Main1 {
    public static void main(String[] args) {
        DisjointSetsUnionBySize ds = new DisjointSetsUnionBySize(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);

        // if 3 and 7 same or not
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionBySize(3, 7);
        if (ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}