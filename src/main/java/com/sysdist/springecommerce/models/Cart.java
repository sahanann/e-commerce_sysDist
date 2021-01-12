package com.sysdist.springecommerce.models;

import javax.persistence.*;

@Entity
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="product_id")
    private Product product;
    private int count;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="order_id")
    private Order order;


    public Cart(Product product, int count) {
        this.product = product;
        this.count = count;
    }


    public Cart() {
        product = new Product();
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
