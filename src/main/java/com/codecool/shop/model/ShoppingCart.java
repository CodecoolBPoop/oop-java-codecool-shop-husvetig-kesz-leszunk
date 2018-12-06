package com.codecool.shop.model;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.ProductDaoMem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart{
    

    public static List<Product> shoppingCartList = new ArrayList<>();

    private static float totalPrice;


    public ShoppingCart(String name, float defaultPrice, String currencyString, String description, ProductCategory productCategory, Supplier supplier) {
        //super(name, defaultPrice, currencyString, description, productCategory, supplier);
    }

    public static float totalPrice() {
        for (int i = 0; i<shoppingCartList.size(); i++) {
            totalPrice += shoppingCartList.get(i).getDefaultPrice();
        }

        return totalPrice;
    }
}
