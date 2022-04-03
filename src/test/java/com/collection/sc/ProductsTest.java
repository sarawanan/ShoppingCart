package com.collection.sc;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductsTest {
    @Test
    public void testGetProductByIdThrowsException() {
        Products products = new Products();
        NoSuchElementException thrown =
                assertThrows(NoSuchElementException.class, () -> products.getProductById(5));
        assertEquals("Product Not Found", thrown.getMessage());
    }

    @Test
    public void testGetProductById() {
        Products products = new Products();
        products.display();
        Product product = products.getProductById(1);
        assertEquals("Rice", product.getName());
    }
}
