package com.sysdist.springecommerce.controllers;

import com.sysdist.springecommerce.services.CartService;
import com.sysdist.springecommerce.services.CheckoutService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/products/checkout")
@Controller
public class CheckoutController {

    private final CartService cartService;
    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService, CartService cartService) {
        this.checkoutService = checkoutService;
        this.cartService = cartService;
    }

    @RequestMapping("")
    public String GetTotalPrice(Model model) {
        model.addAttribute("cartList", cartService.GetCartList());
        model.addAttribute("totalPrice", checkoutService.getTotalPrice(
                cartService.GetCartList()));

        return "CheckoutView";
    }
}
