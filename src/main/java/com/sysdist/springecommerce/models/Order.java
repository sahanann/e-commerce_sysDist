package com.sysdist.springecommerce.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy="order")
    private List<Cart> cart;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user;

    private String status;
    private double total;

    public Order(Long id, List<Cart> cart, User user, String status, double total) {
        this.id = id;
        this.cart = cart;
        this.user = user;
        this.status = status;
        this.total = total;
    }

    public Order() {
        this.cart = new ArrayList<>();
        this.user = new User();
    }

    public Order(List<Cart> cart, User user, String status, double total) {
        this.cart = cart;
        this.user = user;
        this.status = status;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Cart> getProducts() {
        return cart;
    }

    public void setProducts(List<Cart> cart) {
        this.cart = cart;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
