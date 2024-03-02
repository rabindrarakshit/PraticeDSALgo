package com.algorithm.practice.core.compare;

import java.util.Comparator;

public class SortByMarks implements Comparator<Student> {

    @Override
    public int compare(Student s1, Student s2) {
        // increasing order
        // return s1.marks-s2.marks;

        // decreasing order
         return s2.marks - s1.marks;
    }
}
