package com.collection.sc;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;

    public boolean stockAvailable(int qty) {
        return qty < stock;
    }
}
