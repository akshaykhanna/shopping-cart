package org.example;

public class CartProduct extends Product {
    private int quantity;

    public CartProduct(String id, String name, double price, int quantity) {
        super(id, name, price);
        this.quantity = quantity;
    }

    public void increaseQtyBy(int quantity) {
        this.quantity += quantity;
    }

    public double totalPrice() {
        return this.price() * quantity;
    }
}
