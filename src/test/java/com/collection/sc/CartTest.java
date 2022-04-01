package com.collection.sc;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class CartTest {
    @Test
    public void testAddProductToCart() {
        Products products = new Products();
        Cart cart = new Cart();
        Product product = products.getProductById(1);
        cart.addProductToCart(product, 2);
        assertEquals(1, cart.getCartItems().size());
        assertEquals(8, product.getStock());
        assertEquals("Rice", cart.getCartItems().get(0).getProduct().getName());
        cart.display();
    }

    @Test
    public void testRemoveProductFromCart() {
        Products products = new Products();
        Cart cart = new Cart();
        products.getProducts().forEach(product -> cart.addProductToCart(product, 2));
        cart.removeProductFromCart(2);
        assertEquals(20, products.getProductById(2).getStock());
        assertEquals(3, cart.getCartItems().size());
    }

    @Test
    public void testRemoveProductFromCartThrowsExceptions() {
        Cart cart = new Cart();
        cart.display();
        NoSuchElementException noSuchElementException =
                assertThrows(NoSuchElementException.class, () -> cart.removeProductFromCart(5));
        assertNotNull(noSuchElementException);
    }
}
