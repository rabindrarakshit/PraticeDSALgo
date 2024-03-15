package com.algorithm.practice.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// Ref: https://www.algoexpert.io/questions/task-assignment
// Time: O(nlogn + n) | Space: O(n)

public class TasksAssignment {
    public ArrayList<ArrayList<Integer>> taskAssignment(
            int k, ArrayList<Integer> tasks
    ) {
        ArrayList<Integer> indices = new ArrayList<>();
        for(int i=0;i<tasks.size();i++){
            indices.add(i);
        }

        Collections.sort(indices, Comparator.comparingInt(tasks::get));
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int begin =0, end = tasks.size()-1;
        while(begin<end){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(indices.get(begin));
            temp.add(indices.get(end));
            result.add(temp);
            begin++;
            end--;
        }
        return result;
    }
}
