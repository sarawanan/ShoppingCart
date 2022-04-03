package com.collection.sc;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItem {
    private int productId;
    private String productName;
    private double price;
    private int qty;
}
