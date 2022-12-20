package org.example;

import java.util.ArrayList;

import static java.util.Objects.isNull;

public class Cart {
    private ArrayList<CartProduct> products;

    public Cart() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product, int quantityToAdd) {
        if (this.hasProduct(product.id())) {
            this.getProduct(product.id()).increaseQtyBy(quantityToAdd);
        } else
            this.products.add(new CartProduct(product.id(), product.name(), product.price(), quantityToAdd));
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (var cartProduct : this.products) {
            totalPrice += cartProduct.totalPrice();
        }
        return totalPrice;
    }

    private CartProduct getProduct(String pid) {
        return (CartProduct) findByProduct(product -> product.id() == pid);
    }

    private boolean hasProduct(String pid) {
        return !isNull(findByProduct(product -> product.id() == pid));

    }

    private Product findByProduct(Inventory.PredicateProduct predicate) {
        for (var product : this.products) {
            if (predicate.matches(product)) return product;
        }
        return null;
    }

    interface PredicateProduct {
        boolean matches(Product product);
    }
}
