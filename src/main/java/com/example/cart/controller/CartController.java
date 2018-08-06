package com.example.cart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cart.Service.ICartService;
import com.example.cart.model.Product;


@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private ICartService cartService;
    
    public CartController(ICartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/AllProducts/{id}")
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable("id") String cartId) {
    	List<Product> responseProduct=cartService.getAllProducts(cartId);
        return new ResponseEntity<List<Product>>(responseProduct, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> addProduct(@PathVariable("id") String cartId, @RequestBody Product produit) {
        cartService.addProduct(cartId, produit);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeProduct(@PathVariable("id") String cartId, @RequestBody Product produit) {
        cartService.removeProduct(cartId, produit);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/mountProducts/{id}")
    public ResponseEntity<Double> getAmountProducts(@PathVariable("id") String cartId) {
       Double result = cartService.getAllAmountProducts(cartId);
       return new ResponseEntity<Double>(result, HttpStatus.OK);

    }

    





}