package com.codecool.shop.model;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class ShoppingCart {

    private final static Map<Product, Integer> entries = new HashMap<>();

    /**
     * Return the content as stream of oredr items.  This is only
     * consumable once.
     *
     * @returns stream of order items.
     */
    public Stream<OrderItem> getContents() {
        return entries
            .entrySet()
            .stream()
            .map(OrderItem::new);
    }

    public void add(Product product) {
        entries.compute(product, (k, v) -> (v == null) ? 1 : v+1);
    }
}
