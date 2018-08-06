package com.example.cart.Service;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;

@Service
public class CartServiceImpl implements ICartService {


        //Initialize Data
        Product product1 = new Product("1", "Product1", "Descrition1", 100.00);
        Product product2 = new Product("2", "Product2", "Descrition1", 200.00);
        Product product3 = new Product("3", "Product3", "Descrition1", 300.00);

       Cart cart = new Cart("1", Arrays.asList(product1, product2, product3));



    public Cart retrieveCart(String cartId) {

        if (cart.getId().equals(cartId)) {
            return cart;
        }
        return null;
    }


    public List<Product> getAllProducts(String cartId) {
        Cart cart = retrieveCart(cartId);
        if (cart == null) {
            return null;
        }
        Product prd = new Product();
        List<Product> list = new ArrayList<>();
        for (Product prod : cart.getProductList()) {
            list.add(prod);

        }
        return list;
    }

    @Override
    public Product addProduct(String cartId, Product product) {
        Cart cart = retrieveCart(cartId);

        if (cart == null) {
            return null;
        }

        cart.getProductList().add(product);

        return product;
    }


    @Override
    public void removeProduct(String cartId, Product product) {
         cart.getProductList().remove(product);

    }

    @Override
    public Double getAllAmountProducts(String cartId) {
        Cart cart = retrieveCart(cartId);

        if (cart == null) {
            return null;
        }
        Double rest = 0.0;
        for (Product prod : cart.getProductList()) {
            rest = rest +prod.getPrice();

        }
        return rest;
    }
}