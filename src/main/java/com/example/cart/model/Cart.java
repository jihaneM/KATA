package com.example.cart.model;

import java.util.List;

public class Cart {

    private String id ;
    public List<Product> productList;

    public Cart(String id, List<Product> productList) {
        this.id = id;
        this.productList = productList;
    }

    public String getId() {
        return id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setId(String code) {
        this.id = code;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
