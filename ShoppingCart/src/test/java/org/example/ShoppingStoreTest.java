package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingStoreTest {

    private Customer customer;
    private Inventory inventory;
    private ShoppingStore shoppingStore;

    @BeforeEach
    void setUp() {
        // arrange
        customer = new Customer("John", new Cart());
        inventory = new Inventory();
        inventory.addProduct(new InventoryProduct("P1", "Dove", 40, 70));
        inventory.addProduct(new InventoryProduct("P2", "Axe Deo", 30, 150));
        shoppingStore = new ShoppingStore(inventory);
    }

    @Test
    void customerShouldBeAbleToAddADoveItemToCart() {
        // act
        var wasAbleToAddItem = shoppingStore.addItemByName(customer, "Dove", 1);
        var actualCost = shoppingStore.getCustomersTotalCost(customer);

        // assert
        Assertions.assertEquals(true, wasAbleToAddItem);
        Assertions.assertEquals(70, actualCost);
    }

    @Test
    void customerShouldBeAbleToAddAdditionalDoveItemsToCart() {
        shoppingStore.addItemByName(customer, "Dove", 1);
        shoppingStore.addItemByName(customer, "Dove", 2);

        double expectedTotalCost = 210;
        Assertions.assertEquals(expectedTotalCost, shoppingStore.getCustomersTotalCost(customer));
    }

    @Test
    void customerShouldBeAbleAddToMultipleKindOfItemsToCart() {
        shoppingStore.addItemByName(customer, "Dove", 1);
        shoppingStore.addItemByName(customer, "Dove", 2);
        shoppingStore.addItemByName(customer, "Axe Deo", 2);

        double expectedTotalCost = 510;
        Assertions.assertEquals(expectedTotalCost, shoppingStore.getCustomersTotalCost(customer));
    }

    @Test
    void customerShouldBeAbleToGetTheTotalSaleTaxToPaid() {
        shoppingStore.addItemByName(customer, "Dove", 1);
        shoppingStore.addItemByName(customer, "Dove", 2);
        shoppingStore.addItem(customer, "P2", 2);

        double expectedTotalSaleTax = 63.75;
        Assertions.assertEquals(expectedTotalSaleTax, shoppingStore.getCustomersTotalSaleTax(customer));
    }

    @Test
    void customerShouldBeAbleToGetTheTotalAmountToBePaidToStore() {
        shoppingStore.addItemByName(customer, "Dove", 1);
        shoppingStore.addItemByName(customer, "Dove", 2);
        shoppingStore.addItem(customer, "P2", 2);

        double expectedTotalCost = 510;
        double expectedTotalSaleTax = 63.75;
        Assertions.assertEquals(expectedTotalCost + expectedTotalSaleTax, shoppingStore.amountToBePaidBy(customer));
    }

}