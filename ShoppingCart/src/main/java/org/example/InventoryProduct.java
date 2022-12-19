package org.example;

public class InventoryProduct extends Product {
    private int quantity;
    private double price;

    public InventoryProduct(String id, String name, int quantity, double price) {
        super(id, name, price);
        this.quantity = quantity;
        this.price = price;
    }

    public void decreaseQtyBy(int qtyToReduce) {
        this.quantity = this.quantity >= qtyToReduce ? this.quantity - qtyToReduce : 0;
    }
}
