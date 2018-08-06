package com.example.cart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.cart.Service.ICartService;
import com.example.cart.model.Cart;
import com.example.cart.model.Product;

public class UnitServiceTest {
	
	
    @MockBean
    private ICartService cartService;
	
    //Initialize Data
    Product product1 = new Product("1", "Product1", "Descrition1", 100.00);
    Product product2 = new Product("2", "Product2", "Descrition1", 200.00);
    Product product3 = new Product("3", "Product3", "Descrition1", 300.00);

    List<Product> list = new ArrayList<>(Arrays.asList(product1, product2, product3));
     Cart cart = new Cart("1", list);

   
	
	@Test
	public void getAllService() {
	  List <Product> list=cartService.getAllProducts(cart.getId());
	  Assert.assertEquals(list.size(), 3);
	
	} 
	
	
	//@Test
	public void getaddProduct() {
		cartService.addProduct(cart.getId(),product1);
 	Assert.assertEquals(list.size(), 4);
	}
    

	@Test
	public void getremoveProduct() {
		cartService.removeProduct(cart.getId(),product1);
 	Assert.assertEquals(list.size(), 2);
	}
	
	
	@Test
	public void getamountProduct() {
	Double result=cartService.getAllAmountProducts(cart.getId());
 	Assert.assertEquals(result, 600.00,0.001);
 	
	}
	


}
