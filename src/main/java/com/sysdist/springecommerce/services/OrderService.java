package com.sysdist.springecommerce.services;

import com.sysdist.springecommerce.models.Order;
import com.sysdist.springecommerce.models.User;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private Order order;

    public void createOrder(CheckoutService checkoutService, User user) {
        order = new Order(
                checkoutService.getCheckout().getCartItems(),
                user,
                "EN PREPARATION",
                checkoutService.getTotalPrice()
        );
    }

}
