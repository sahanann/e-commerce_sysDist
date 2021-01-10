package com.sysdist.springecommerce.controllers;

import com.sysdist.springecommerce.services.CartService;
import com.sysdist.springecommerce.services.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@RequestMapping("/products/cart")
@Controller
public class CartController {

    private final ProductServiceImpl productService;
    private final CartService cartService;

    public CartController(CartService cartService, ProductServiceImpl productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @RequestMapping("")
    public String GetItemsFromCart(Model model) {

        if (model.getAttribute("cartList") == null)
            model.addAttribute("cartList", cartService.GetCartList());

        return "cartView";
    }

    @RequestMapping("/delete/{id}")
    public RedirectView DeleteItemFromCart(@PathVariable int id) {

        System.out.println("job");
        cartService.DeleteItemFromCart(productService.getProductById(id));

        return new RedirectView("/products/cart");
    }

}
