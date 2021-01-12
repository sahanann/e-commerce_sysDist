package com.sysdist.springecommerce.services;

import com.sysdist.springecommerce.models.Cart;
import com.sysdist.springecommerce.models.Checkout;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutService {

    private final int express = 10;
    private final int normal = 5;
    private int totalPrice = 0;



    private Checkout checkout = new Checkout();

    public CheckoutService() {
//        checkout = new Checkout();
    }

    public double calculateTotalPrice(List<Cart> cartList, TvaService tvaService) {
        for (Cart cart: cartList)
            totalPrice += this.getCalcPrice(tvaService.tvaPercent(cart.getProduct().getCategory()),
                        cart.getProduct().getPrice()) * cart.getCount();


        return totalPrice;
    }

    public void addDeliveryMoney(double money) {
        totalPrice += money;
    }

    public double getCalcPrice(int tva, double price) {
        return price * (1 + (tva/100));
    }

    public Checkout getCheckout() {
        return checkout;
    }

    public void setCheckout(Checkout checkout) {
        this.checkout = checkout;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
