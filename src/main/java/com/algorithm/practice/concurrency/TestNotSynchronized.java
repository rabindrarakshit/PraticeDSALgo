package com.algorithm.practice.concurrency;

public class TestNotSynchronized {

    int count = 0;

    public void increment(){
        this.count++;
        System.out.println(count);
    }

    public int getCount(){
        return this.count;
    }
}
