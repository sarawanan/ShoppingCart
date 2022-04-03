package com.collection.sc;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CartTest {
    @Test
    public void testAddProductToCart() {
        Products products = new Products();
        Cart cart = new Cart();
        Product product = products.getProductById(1);
        cart.addProductToCart(product, 2);
        assertEquals(1, cart.getItems().size());
        assertEquals(8, product.getStock());
        assertEquals("Rice", cart.getItems().get(0).getProductName());
        cart.display();
    }

    @Test
    public void testRemoveProductFromCart() {
        Products products = new Products();
        Cart cart = new Cart();
        products.getProducts().forEach(product -> cart.addProductToCart(product, 2));
        Product product = products.getProductById(1);
        cart.removeProductFromCart(product);
        assertEquals(10, product.getStock());
        assertEquals(3, cart.getItems().size());
    }

    @Test
    public void testRemoveProductFromCartThrowsExceptions() {
        Products products = new Products();
        Cart cart = new Cart();
        cart.display();
        cart.addProductToCart(products.getProductById(1), 2);
        cart.display();
        Product product = products.getProductById(2);
        NoSuchElementException thrown =
                assertThrows(NoSuchElementException.class, () -> cart.removeProductFromCart(product));
        assertEquals("Item not found for this product id!", thrown.getMessage());
    }
}
