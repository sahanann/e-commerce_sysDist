package com.sysdist.springecommerce.models;

import java.util.ArrayList;
import java.util.List;

public class Checkout {

    private List<Cart> cartItems;
    private DeliveryType deliveryType;


    public Checkout(List<Cart> cartItems, DeliveryType deliveryType) {
        this.cartItems = cartItems;
        this.deliveryType = deliveryType;
    }

    public Checkout() {
        cartItems = new ArrayList<>();
        deliveryType = new DeliveryType();
    }

    public List<Cart> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Cart> cartItems) {
        this.cartItems = cartItems;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
}
