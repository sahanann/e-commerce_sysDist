package com.sysdist.springecommerce.controllers;

import com.sysdist.springecommerce.models.Checkout;
import com.sysdist.springecommerce.models.DeliveryType;
import com.sysdist.springecommerce.services.CartService;
import com.sysdist.springecommerce.services.CheckoutService;
import com.sysdist.springecommerce.services.TvaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/products/checkout")
@Controller
public class CheckoutController {

    private final CartService cartService;
    private final CheckoutService checkoutService;
    private final TvaService tvaService;

    public CheckoutController(CheckoutService checkoutService,
                              CartService cartService, TvaService tvaService) {
        this.checkoutService = checkoutService;
        this.cartService = cartService;
        this.tvaService = tvaService;

        checkoutService.setCheckout(
                new Checkout(cartService.GetCartList(), new DeliveryType())
        );
    }

    @RequestMapping("")
    public String GetTotalPrice(Model model) {
        List<DeliveryType> deliveryTypeList = Arrays.asList(
                new DeliveryType("Express", 10),
                new DeliveryType("Normal", 5)
        );
        model.addAttribute("cartList", cartService.GetCartList());
        model.addAttribute("tvaService", tvaService);
        model.addAttribute("cOutService", checkoutService);

        model.addAttribute("checkout", checkoutService.getCheckout());
        model.addAttribute("deliveryList", deliveryTypeList);

        model.addAttribute("deliveryMode", new DeliveryType());



        double totalPrice = checkoutService.calculateTotalPrice(
                cartService.GetCartList(),
                tvaService
        );
//        for (Cart cart: cartService.GetCartList())
//            totalPrice += checkoutService.getCalcPrice(
//                    tvaService.tvaPercent(cart.getProduct().getCategory()),
//                    cart.getProduct().getPrice()
//            ) * cart.getCount();

        model.addAttribute("totalPrice", totalPrice);

        return "CheckoutView";
    }
}
