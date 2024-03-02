package com.algorithm.practice.core.compare;

public class Customer implements Comparable<Customer>{
    Integer rank;
    String name;
    public Customer(String name, Integer rank){
        this.rank = rank;
        this.name = name;
    }

    public Integer getRank(){
        return rank;
    }

    @Override
    public int compareTo(Customer otherCustomer) {
        return Integer.compare(getRank(), otherCustomer.getRank());
    }
}
