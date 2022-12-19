package org.example;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<InventoryProduct> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public boolean hasProductByName(String prodName) {
        for (var product: this.products) {
            if(product.name() == prodName)
                return true;
        }
        return false;
    }

    public InventoryProduct getProduct(String pid) {
        for (var product: this.products) {
            if(product.id() == pid)
                return product;
        }
        return null;
    }
    public InventoryProduct getProductByName(String prodName) {
        for (var product: this.products) {
            if(product.name() == prodName)
                return product;
        }
        return null;
    }

    public void decreaseInventoryOfAProduct(String pid, int quantity) {
        this.getProduct(pid).decreaseQtyBy(quantity);
    }

    public void addProduct(InventoryProduct inventoryProduct) {
        this.products.add(inventoryProduct);
    }

    public boolean hasProduct(String pid) {
        return this.getProduct(pid) != null;
    }
}
