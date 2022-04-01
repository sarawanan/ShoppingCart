package com.collection.sc;

import lombok.Getter;

import java.util.List;

@Getter
public class Products {
    private final List<Product> products;

    public Products() {
        products = List.of(
                Product.builder().id(1).name("Rice").price(100).stock(10).build(),
                Product.builder().id(2).name("Wheat").price(90).stock(20).build(),
                Product.builder().id(3).name("Sugar").price(80).stock(30).build(),
                Product.builder().id(4).name("Bread").price(70).stock(40).build());
    }

    public void display() {
        StringBuffer sb = new StringBuffer();
        sb.append("Products List\n");
        products.forEach(product -> sb.append(String.format("%s : Name: %s - Price: %s - Stock: %s%n",
                product.getId(), product.getName(), product.getPrice(), product.getStock())));
        System.out.println(sb);
    }

    public Product getProductById(int productId) {
        return products.parallelStream()
                .filter(product -> product.getId() == productId)
                .findFirst().orElseThrow();
    }
}
