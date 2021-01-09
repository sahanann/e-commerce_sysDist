package com.sysdist.springecommerce.controllers;

import com.sysdist.springecommerce.models.Product;
import com.sysdist.springecommerce.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @RequestMapping("/products")
    @GetMapping("/products")
    public String GetAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        return "products";
//        return "products.html";
    }



//    @GetMapping("/login")
//    public String login() {
////        List<Product> products = new ArrayList<>();
////        products.add(new Product(2L, "ddez", 100, 3));
////        model.addAttribute("products", products);
//        return "login";
//    }
}
