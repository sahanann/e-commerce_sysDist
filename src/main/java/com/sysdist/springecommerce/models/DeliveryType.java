package com.sysdist.springecommerce.models;

public class DeliveryType {
    private String name;
    private double price;

    public DeliveryType(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public DeliveryType() {

    }

    @Override
    public String toString() {
        return name + " - " + price + "$";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price == 5)
            name = "Normal";
        else
            name = "Express";

        this.price = price;
    }
}
