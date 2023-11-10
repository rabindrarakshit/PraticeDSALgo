package com.algorithm.practice.test;

import java.math.BigDecimal;
import java.util.List;

public class SimpleSoldProduct {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String type;

    public List<SoldProduct> getSoldProduct() {
        return soldProduct;
    }

    public void setSoldProduct(List<SoldProduct> soldProduct) {
        this.soldProduct = soldProduct;
    }

    List<SoldProduct> soldProduct;
}
