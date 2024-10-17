package com.algorithm.practice.arrays.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinAreaRectangle {
    public static int minimumAreaRectangle(int[][] points) {
        Set<String> pointSet = createPointSet(points);
        int minArea = Integer.MAX_VALUE;
        for(int[] pointA : points){
            for(int[] pointB : points){
                if(pointA[0]==pointB[0] || pointA[1]==pointB[1]){
                    continue;
                }
                int x1 = pointA[0];
                int y1 = pointA[1];
                int x2 = pointB[0];
                int y2 = pointB[1];



                if(pointSet.contains(Integer.toString(x1)+":"+Integer.toString(y2))
                        && pointSet.contains(Integer.toString(x2)+":"+Integer.toString(y1))){
                    int currentArea = Math.abs(x2-x1)*Math.abs(y2-y1);
                    minArea = Math.min(currentArea, minArea);
                }
            }
        }
        return minArea!=Integer.MAX_VALUE? minArea:0;
    }

    static Set<String> createPointSet(int[][] points){
        Set<String> set = new HashSet<>();
        for (int[] point : points){
            set.add(Integer.toString(point[0])+":"+Integer.toString(point[1]));
        }
        return set;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{ {1, 4},
                {3, 5},
                {7, 1},
                {5, 4},
                {4, 5},
                {9, 2},
                {1, 3},
                {2, 8}};
        System.out.println(minimumAreaRectangle(points));
    }
}
