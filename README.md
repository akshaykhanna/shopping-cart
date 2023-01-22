# ShoppingCart

## Problem
As you work through the steps, you’ll create code to allow a user to add products to a shopping cart, calculate the total price and then the sales tax for the items contained in the cart. As mentioned previously, we are not looking for a command line or a web application, so please just use your tests to drive the code (e.g. class libraries).

Please Note: All totals should be rounded up to 2 decimal places, i.e. 0.565 should result in 0.57 but 0.5649 should result in 0.56. This is baisically the same rounding you learned at school, but you can follow this link if you really want more details.

### Step 1: Add products to the shopping cart.
Given:

An empty shopping cart
And a product, Dove Soap with a unit price of 39.99
When:

The user adds 5 Dove Soaps to the shopping cart
Then:

The shopping cart should contain 5 Dove Soaps each with a unit price of 39.99
And the shopping cart’s total price should equal 199.95

### Step 2: Add additional products of the same type to the shopping cart.
Given:

An empty shopping cart
And a product, Dove Soap with a unit price of 39.99
When:

The user adds 5 Dove Soaps to the shopping cart
And then adds another 3 Dove Soaps to the shopping cart
Then:

The shopping cart should contain 8 Dove Soaps each with a unit price of 39.99
And the shopping cart’s total price should equal 319.92

### Step 3: Calculate the tax rate of the shopping cart with multiple items
Given:

An empty shopping cart
And a product, Dove Soap with a unit price of 39.99
And another product, Axe Deo with a unit price of 99.99
And a sales tax rate of 12.5%
When:

The user adds 2 Dove Soaps to the shopping cart
And then adds 2 Axe Deos to the shopping cart
Then:

The shopping cart should contain 2 Dove Soaps each with a unit price of 39.99
And the shopping cart should contain 2 Axe Deos each with a unit price of 99.99
And the total sales tax amount for the shopping cart should equal 35.00
And the shopping cart’s total price should equal 314.96

## Purposed Solution Design 

