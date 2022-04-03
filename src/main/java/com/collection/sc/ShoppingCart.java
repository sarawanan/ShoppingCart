package com.collection.sc;

import java.util.Scanner;

public class ShoppingCart {
    static Products products;
    static Cart cart;
    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        products = new Products();
        cart = new Cart();

        do {
            try {
                System.out.println("MENU: [1: Products] [2: Add to Cart] [3: Remove from Cart] [4: Display Cart] [0: Exit]");
                int input = scanner.nextInt();

                switch (input) {
                    case 1 -> products.display();
                    case 2 -> {
                        System.out.print("Enter product id to add");
                        Product product = products.getProductById(scanner.nextInt());
                        System.out.print("Quantity");
                        int qty = scanner.nextInt();
                        if (qty < product.getStock()) {
                            cart.addProductToCart(product, qty);
                            System.out.println("Product successfully added to cart");
                        } else {
                            System.out.println("Requested quantity exceeds available stock!");
                        }
                    }
                    case 3 -> {
                        System.out.print("Enter product id to remove");
                        cart.removeProductFromCart(products.getProductById(scanner.nextInt()));
                    }
                    case 4 -> cart.display();
                    case 0 -> System.exit(0);
                }
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                scanner.next();
            }
        } while (true);
    }
}
