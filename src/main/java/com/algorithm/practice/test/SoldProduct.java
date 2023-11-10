package com.algorithm.practice.test;

import java.math.BigDecimal;

public class SoldProduct {
    String name;
    String version;
    String price;

    public SoldProduct(){}

    public SoldProduct(String name, String version, String price){
        this.name = name;
        this.version = version;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getVersion(){
        return version;
    }

    public String getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String asRawMaterial(){
        String rawName = getName() + "Raw";
        System.out.println(rawName);
        return rawName;
    }
}
