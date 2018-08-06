package com.example.cart;

import com.example.cart.Service.CartServiceImpl;
import com.example.cart.controller.CartController;
import com.example.cart.model.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@RunWith(SpringRunner.class)
@WebMvcTest(value = CartController.class, secure = false)
public class CartControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CartServiceImpl cartService;

    @Test
    public void retrieveAllProduct() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                    "/cart/AllProducts/{id}").accept(
                    MediaType.APPLICATION_JSON);
             mockMvc.perform(requestBuilder).andExpect(status().isOk());

        }

    @Test
    public Product addProduct(String cartId, Product product) throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                    "/cart/{id}").accept(
                    MediaType.APPLICATION_JSON);

             mockMvc.perform(requestBuilder).andExpect(status().isOk());
             
             return product;

        }
    
    @Test
    public void removeProduct(String cartId, String product) throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                    "/cart/{id}/{product_id}").accept(
                    MediaType.APPLICATION_JSON);

             mockMvc.perform(requestBuilder).andExpect(status().isOk());

        }
   

}
