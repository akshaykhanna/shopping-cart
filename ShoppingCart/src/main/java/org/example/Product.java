package org.example;

public class Product {
    private String id;
    private String name;
    private double price;

    public Product(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String id() {
        return this.id;
    }

    public String name() {
        return this.name;
    }

    protected double price() {
        return this.price;
    }
}
