package com.collection.sc;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Getter
public class Cart {
    List<CartItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addProductToCart(Product product, int qty) {
        items.add(CartItem.builder()
                .productId(product.getId())
                .productName(product.getName())
                .price(product.getPrice())
                .qty(qty)
                .build());
        product.setStock(product.getStock() - qty);
    }

    public void removeProductFromCart(Product product) {
        CartItem cartItem = items.parallelStream()
                .filter(item -> item.getProductId() == product.getId()).findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item not found for this product id!"));
        product.setStock(product.getStock() + cartItem.getQty());
        items.remove(cartItem);
    }

    public void display() {
        if (items.size() > 0) {
            items.forEach(System.out::println);
            System.out.println("Total Price: " + items.stream().mapToDouble(CartItem::getPrice).sum());
        } else {
            System.out.println("No items in cart");
        }
    }
}
