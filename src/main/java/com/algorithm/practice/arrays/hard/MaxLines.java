package com.algorithm.practice.arrays.hard;

import java.util.HashMap;
import java.util.Map;

public class MaxLines {
    public static int lineThroughPoints(int[][] points) {
        int max = 1;
        for(int i=0;i<points.length;i++){
            Map<String, Integer> map = new HashMap<>();
            for(int j=i+1; j<points.length;j++){
                String slope = getSlope(points[i], points[j]);
                map.put(slope, map.getOrDefault(slope,1)+1);
            }
            for(int count: map.values()){
                max = Math.max(max, count);
            }
        }
        return max;
    }

    static String getSlope(int[] pointA, int[] pointB){
        int yDiff = pointB[1]-pointA[1];
        int xDiff = pointB[0]-pointA[0];
        String slope = Integer.toString(1)+":"+Integer.toString(0);
        if(xDiff==0){
            return slope;
        }
        int gcd = getGCD(Math.abs(xDiff), Math.abs(yDiff));
        xDiff/=gcd;
        yDiff/=gcd;
        if(xDiff<0){
            xDiff*=-1;
            yDiff*=-1;
        }
        return Integer.toString(yDiff)+":"+Integer.toString(xDiff);
    }

    static int getGCD(int x, int y){
        while(true){
            if(x==0)
                return y;
            if(y==0)
                return x;
            int temp = x;
            x = y;
            y = temp % y;
        }
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
        System.out.println(lineThroughPoints(points));
    }
}
