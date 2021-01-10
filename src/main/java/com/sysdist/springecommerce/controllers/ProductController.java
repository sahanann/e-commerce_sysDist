package com.sysdist.springecommerce.controllers;

import com.sysdist.springecommerce.models.Cart;
import com.sysdist.springecommerce.models.Product;
import com.sysdist.springecommerce.services.CartService;
import com.sysdist.springecommerce.services.ProductService;
import com.sysdist.springecommerce.services.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.*;

@Controller
public class ProductController {

    private final ProductServiceImpl productService;
    private final CartService cartService;

    public ProductController(ProductServiceImpl productService, CartService cartService) {
        this.productService = productService;
        this.cartService = cartService;

//        products = productService.getAllProducts();
    }

//    @RequestMapping("/products")
    @GetMapping("/products")
    public String GetAllProducts(Model model) {


        model.addAttribute("products", productService.getProducts());
        model.addAttribute("itemCount", cartService.getItemCount());

        return "products";
//        return "products.html";
    }

    @RequestMapping("/products/{id}")
    public RedirectView AddItemToCart(@PathVariable int id) {
        for (Product p:productService.getProducts()) {
            if (p.getId() == id) {
                cartService.AddItemToCart(p);
                p.decQuantity();
            }

        }


        return new RedirectView("/products");
    }

}
