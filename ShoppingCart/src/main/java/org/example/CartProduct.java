package org.example;

public class CartProduct extends Product {
    private int qunatity;

    public CartProduct(String id, String name, double price, int quantity) {
        super(id, name, price);
        this.qunatity = quantity;
    }

    public void increaseQtyBy(int quantity) {
        this.qunatity += quantity;
    }

    public double totalPrice() {
        return this.price() * qunatity;
    }
}
