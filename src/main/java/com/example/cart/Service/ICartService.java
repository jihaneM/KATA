package com.example.cart.Service;

import com.example.cart.model.Product;

import java.util.List;


public interface ICartService {

     List<Product> getAllProducts(String cartId);
     Product addProduct(String cartId, Product product);
     void removeProduct(String cartId, Product product);
     Double getAllAmountProducts(String cartId);
}