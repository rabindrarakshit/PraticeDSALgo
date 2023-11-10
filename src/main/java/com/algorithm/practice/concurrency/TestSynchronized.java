package com.algorithm.practice.concurrency;

public class TestSynchronized {

    int count = 0;

    public synchronized void inc(){
        count++;
    }

    public void increment(){
        synchronized(this){
            count++;
            System.out.println(count);
        }
    }

    public synchronized int getCount(){
        return this.count;
    }

    public int getCt(){
        synchronized(this){
            return this.count;
        }
    }
}
