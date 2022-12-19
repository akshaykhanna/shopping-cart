package org.example;

public class ShoppingStore {
    private Inventory inventory;

    public ShoppingStore(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean addItemByName(Customer customer, String prodName, int quantity) {
        if (inventory.hasProductByName(prodName)) {
            Product inventoryProduct = inventory.getProductByName(prodName);
            inventory.decreaseInventoryOfAProduct(inventoryProduct.id(), quantity);
            customer.cart().addProduct(inventoryProduct.id(), prodName, quantity, inventoryProduct.price());
            return true;
        } else
            return false;
    }

    public boolean addItem(Customer customer, String pid, int quantity) {
        if (inventory.hasProduct(pid)) {
            Product inventoryProduct = inventory.getProduct(pid);
            inventory.decreaseInventoryOfAProduct(inventoryProduct.id(), quantity);
            customer.cart().addProduct(inventoryProduct.id(), inventoryProduct.name(), quantity, inventoryProduct.price());
            return true;
        } else
            return false;
    }

    public double amountToBePaidBy(Customer customer) {
        return this.getCustomersTotalCost(customer) + this.getCustomersTotalSaleTax(customer);
    }

    public double getCustomersTotalCost(Customer customer) {
        return customer.cart().getTotalPrice();
    }

    public double getCustomersTotalSaleTax(Customer customer) {
        Bill bill = new Bill(customer);
        return bill.getTotalSaleTax();
    }
}
