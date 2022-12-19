package org.example;

public class Bill {
    private static final double SALE_TAX_RATE = 12.5;
    private Customer customer;

    public Bill(Customer customer) {
        this.customer = customer;
    }


    public double getTotalSaleTax() {
        return (this.customer.cart().getTotalPrice() * SALE_TAX_RATE) / 100;
    }
}
