package com.sysdist.springecommerce.services;

import com.sysdist.springecommerce.models.Cart;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService {

    public double getTotalPrice(List<Cart> cartList) {
        double price = 0;
        for (Cart cart: cartList)
            price += cart.getPrice();

        return price;
    }

}
