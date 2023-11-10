package com.algorithm.practice.test;

public class Student {

    private Student(){};
    Student(String name, Integer rollNo){
        this.name = name;
        this.rollNo = rollNo;
    }
    private String name;
    private Integer rollNo;

    public String getName(){
        return name;
    }

    public Integer getRollNo(){
        return rollNo;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRollNo(Integer rollNo){
        this.rollNo = rollNo;
    }

}
