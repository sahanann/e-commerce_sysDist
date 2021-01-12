package com.sysdist.springecommerce.controllers;

import com.sysdist.springecommerce.models.DeliveryType;
import com.sysdist.springecommerce.services.CheckoutService;
import com.sysdist.springecommerce.services.OrderService;
import com.sysdist.springecommerce.services.UserDetailsServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;


@RequestMapping("/products/order")
@Controller
public class OrderController {

    private final CheckoutService checkoutService;
    private final UserDetailsServiceImpl userDetailsService;
    private final OrderService orderService;

    public OrderController(CheckoutService checkoutService,
            UserDetailsServiceImpl userDetailsService,
            OrderService orderService) {
        this.checkoutService = checkoutService;
        this.userDetailsService = userDetailsService;
        this.orderService = orderService;
    }

    @PostMapping
    public String GetOrder(DeliveryType deliveryType, Model model) {
        checkoutService.addDeliveryMoney(deliveryType.getPrice());

        model.addAttribute("delivMode", deliveryType);
        model.addAttribute("totalPrice", checkoutService.getTotalPrice());

        return "orderView";
    }

    @PostMapping("/confirm")
    public RedirectView ConfirmOrder() {
        orderService.createOrder(checkoutService, userDetailsService.getUser());
        return new RedirectView("/products");
    }

}
