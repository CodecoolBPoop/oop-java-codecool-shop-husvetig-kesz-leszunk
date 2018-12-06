package com.codecool.shop.model;

import java.util.Map;

public class OrderItem {
    private final Product product;
    private final int amount;

    public OrderItem(Map.Entry<Product, Integer> mapEntry) {
        product = mapEntry.getKey();
        amount = mapEntry.getValue();
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }
}
