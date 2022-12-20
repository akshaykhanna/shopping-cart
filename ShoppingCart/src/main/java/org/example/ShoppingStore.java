package org.example;

public class ShoppingStore {
    private Inventory inventory;

    public ShoppingStore(Inventory inventory) {
        this.inventory = inventory;
    }

    public boolean addItemByName(Customer customer, String prodName, int quantityToAdd) {
        if (inventory.hasProductByName(prodName)) {
            updateInventoryAndCustomerCart(customer, quantityToAdd, inventory.getProductByName(prodName));
            return true;
        }
        return false;
    }

    public boolean addItem(Customer customer, String pid, int quantityToAdd) {
        if (inventory.hasProduct(pid)) {
            updateInventoryAndCustomerCart(customer, quantityToAdd, inventory.getProduct(pid));
            return true;
        }
        return false;
    }

    private void updateInventoryAndCustomerCart(Customer customer, int quantityToAdd, Product product) {
        inventory.decreaseInventoryOfAProduct(product.id(), quantityToAdd);
        customer.addItemToCart(product, quantityToAdd);
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
