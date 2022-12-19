package org.example;

public class Customer {
    private String name;
    private Cart cart;

    public Customer(String name, Cart cart) {
        this.name = name;
        this.cart = cart;
    }

    public Cart cart() {
        return this.cart;
    }
}
