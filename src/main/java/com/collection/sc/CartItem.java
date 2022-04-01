package com.collection.sc;

import lombok.Data;

@Data
public class CartItem {
    private final Product product;
    private final int qty;
    private final double price;

    public CartItem(Product product, int qty) {
        this.product = product;
        this.qty = qty;
        this.price = product.getPrice() * qty;
    }

    public void display() {
        System.out.printf("Name: %s - Qty: %s - Price: %s%n%n", product.getName(), qty, price);
    }
}
