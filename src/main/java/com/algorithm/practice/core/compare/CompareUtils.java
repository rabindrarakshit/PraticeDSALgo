package com.algorithm.practice.core.compare;

import com.algorithm.practice.core.compare.Student;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareUtils {
    public static void main(String[] args) {
        Student s1 = new Student("Rabi",90);
        Student s2 = new Student("Aru", 95);
        Student s3 = new Student("Tamal", 92);

        List<Student> listOfStudents =  new ArrayList<>(List.of(s1, s2, s3));
        Collections.sort(listOfStudents, new SortByName());
        listOfStudents.stream().map(student -> student.name).forEach(System.out::println);

        System.out.println();

        Collections.sort(listOfStudents, new SortByMarks());
        listOfStudents.stream().map(student -> student.name).forEach(System.out::println);

        System.out.println();

        Customer c1 = new Customer("Aru", 1);
        Customer c2 = new Customer("Tamal", 2 );
        Customer c3 = new Customer("Rabi", 3);
        List<Customer> customers = new ArrayList<>(List.of(c1, c2, c3));
        Collections.sort(customers);
        customers.stream().map(c-> c.name).forEach(c-> System.out.println(c));
    }
}
