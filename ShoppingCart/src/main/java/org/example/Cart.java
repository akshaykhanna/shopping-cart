package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartProduct> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(String pid, String prodName, int quantity, double price) {
        if (this.hasProduct(pid)) {
            this.getProduct(pid).increaseQtyBy(quantity);
        } else
            this.products.add(new CartProduct(pid, prodName, price, quantity));
    }

    private CartProduct getProduct(String pid) {
        for (var product : this.products) {
            if (product.id() == pid)
                return product;
        }
        return null;
    }

    private boolean hasProduct(String pid) {
        for (var product : this.products) {
            if (product.id() == pid)
                return true;
        }
        return false;

    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (var cartProduct : this.products) {
            totalPrice += cartProduct.totalPrice();
        }
        return totalPrice;
    }
}
