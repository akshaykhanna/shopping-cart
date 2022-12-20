package org.example;

import java.util.ArrayList;

import static java.util.Objects.isNull;

public class Inventory {

    private ArrayList<InventoryProduct> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public boolean hasProduct(String pid) {
        return !isNull(findByProduct(product -> product.id() == pid));
    }

    public boolean hasProductByName(String prodName) {
        return !isNull(findByProduct(product -> product.name() == prodName));
    }

    public InventoryProduct getProduct(String pid) {
        return (InventoryProduct) findByProduct(product -> product.id() == pid);
    }

    public InventoryProduct getProductByName(String prodName) {
        return (InventoryProduct) findByProduct(product -> product.name() == prodName);
    }

    public void addProduct(InventoryProduct inventoryProduct) {
        this.products.add(inventoryProduct);
    }

    public void decreaseInventoryOfAProduct(String pid, int quantity) {
        this.getProduct(pid).decreaseQtyBy(quantity);
    }

    private Product findByProduct(PredicateProduct predicate) {
        for (var product : this.products) {
            if (predicate.matches(product)) return product;
        }
        return null;
    }

    interface PredicateProduct {
        boolean matches(Product product);
    }

}
