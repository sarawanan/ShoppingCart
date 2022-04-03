package com.collection.sc;

import lombok.Getter;

import java.util.List;
import java.util.NoSuchElementException;

@Getter
public class Products {
    List<Product> products;

    public Products() {
        products = List.of(
                Product.builder().id(1).name("Rice").price(100).stock(10).build(),
                Product.builder().id(2).name("Wheat").price(90).stock(20).build(),
                Product.builder().id(3).name("Sugar").price(80).stock(30).build(),
                Product.builder().id(4).name("Bread").price(70).stock(40).build());
    }

    public Product getProductById(int productId) {
        return products.parallelStream()
                .filter(product -> product.getId() == productId)
                .findFirst().orElseThrow(() -> new NoSuchElementException("Product Not Found"));
    }

    public void display() {
        products.forEach(System.out::println);
    }
}
