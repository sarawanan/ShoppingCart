package com.collection.sc;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
public class Cart {
    List<CartItem> cartItems;

    public Cart() {
        cartItems = new ArrayList<>();
    }

    public void addProductToCart(Product product, int qty) {
        cartItems.add(new CartItem(product, qty));
        product.setStock(product.getStock() - qty);
    }

    public void removeProductFromCart(int productId) {
        CartItem cartItem = getCartItemByProductId(productId);
        Product product = cartItem.getProduct();
        product.setStock(product.getStock() + cartItem.getQty());
        cartItems.remove(cartItem);

    }

    private CartItem getCartItemByProductId(int productId) {
        return Optional.of(cartItems.stream()
                .filter(cartItem -> cartItem.getProduct().getId() == productId)
                .findFirst()).get().orElseThrow();
    }

    public void display() {
        if (cartItems.size() > 0) {
            System.out.println("Shopping Cart\n");
            cartItems.forEach(CartItem::display);
            double total = cartItems.stream().mapToDouble(CartItem::getPrice).sum();
            System.out.println("Total Price: " + total);
        } else {
            System.out.println("No items in cart");
        }
    }
}
