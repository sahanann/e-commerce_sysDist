package com.sysdist.springecommerce.models;

public class Cart {

    private Product product;
    private int count;


    public Cart(Product product, int count) {
        this.product = product;
        this.count = count;
    }


    public Cart() {

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void incCount() {
        this.count++;
    }

    public void decCount() {
        this.count--;
    }

    public double getPrice() {
        return product.getPrice() * count;
    }

}
