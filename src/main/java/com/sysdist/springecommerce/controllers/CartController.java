package com.sysdist.springecommerce.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    @RequestMapping("/products/1")
    public String AddItemToCart() {
        return "products";
    }
}
