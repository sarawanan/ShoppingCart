package com.collection.sc;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ProductsTest {
    Products products;

    @BeforeAll
    public void setUp() {
        products = new Products();
    }

    @Test
    public void testInitializeProducts() {
        assertEquals(4, products.getProducts().size());
        products.display();
    }

    @Test
    public void testGetProductByIdThrowsException() {
        NoSuchElementException thrown =
                assertThrows(NoSuchElementException.class, () -> products.getProductById(5));
        assertNotNull(thrown);
    }

    @Test
    public void testGetProductById() {
        Product product = products.getProductById(1);
        assertEquals("Rice", product.getName());
    }

    @Test
    public void testProductStockAvailability() {
        Product product = products.getProductById(1);
        assertTrue(product.stockAvailable(4));
    }
}
