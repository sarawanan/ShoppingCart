package com.collection.sc;

import java.util.Scanner;

public class ShoppingCart {
    Products products;
    Cart cart;

    ShoppingCart() {
        products = new Products();
        cart = new Cart();
    }

    public void landingScreen() {
        do {
            System.out.println("MENU: [1: Products] [2: Add to Cart] [3: Remove from Cart] [4: Display Cart] [0: Exit]");
            int input = getUserInput();

            switch (input) {
                case 1 -> products.display();
                case 2 -> addProductToCart();
                case 3 -> removeProductFromCart();
                case 4 -> cart.display();
                case 0 -> System.exit(0);
            }
        } while (true);
    }

    private void removeProductFromCart() {
        System.out.print("Enter product id to remove");
        int productId = getUserInput();
        cart.removeProductFromCart(productId);
    }

    private void addProductToCart() {
        System.out.print("Enter product id to add");
        Product product = products.getProductById(getUserInput());
        System.out.print("Quantity");
        int qty = getUserInput();
        if (product.stockAvailable(qty)) {
            cart.addProductToCart(product, qty);
        } else {
            System.out.println("Requested quantity exceeds available stock");
        }
    }

    public int getUserInput() {
        int input = -1;
        try {
            System.out.print(" >> ");
            input = new Scanner(System.in).nextInt();
        } catch (Exception e) {
            System.out.println("Please enter a valid option");
        }
        return input;
    }
}
