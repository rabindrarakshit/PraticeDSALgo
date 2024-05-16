package com.algorithm.practice.graph.striver.mst;

//Ref: https://takeuforward.org/data-structure/most-stones-removed-with-same-row-or-column-dsu-g-53/

import java.util.HashSet;
import java.util.Set;

/*
* Time Complexity: O(N), where N = total no. of stones. Here we have just traversed the given stones array several times. And inside those loops, every operation is apparently taking constant time. So, the time complexity is only the time of traversal of the array.

Space Complexity: O(2* (max row index + max column index)) for the parent and size array inside the Disjoint Set data structure.
* */

public class MostStonesRemoved {
    static int mostStonesRemoved(int[][] arr) {
        int maxRow=Integer.MIN_VALUE, maxCol=Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                maxRow = Math.max(maxRow, arr[i][0]);
                maxCol = Math.max(maxCol, arr[i][1]);
            }
        }

        DisjointSetsUnionBySize ds = new DisjointSetsUnionBySize(maxRow+maxCol+1);
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            int row = arr[i][0];
            int col = arr[i][1] + maxRow + 1;
            ds.unionBySize(row,col);
            set.add(row);
            set.add(col);
        }

        int comp = 0;
        for(Integer i: set){
            if(ds.findParent(i)==i){
                comp++;
            }
        }
        int stones = arr.length;
        return stones - comp;
    }

    public static void main(String[] args) {
        int[][] stones = {
                {0, 0}, {0, 2},
                {1, 3}, {3, 1},
                {3, 2}, {4, 3}
        };

        int ans = mostStonesRemoved(stones);
        System.out.println("The maximum number of stones we can remove is: " + ans);
    }
}
