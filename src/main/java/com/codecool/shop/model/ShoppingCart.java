package com.codecool.shop.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart extends Product{
    

    public static List<Product> shoppingCartList = new ArrayList<>();


    public ShoppingCart(String name, float defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier) {
        super(name, defaultPrice, currencyString, description, productCategory, supplier);
    }
}
