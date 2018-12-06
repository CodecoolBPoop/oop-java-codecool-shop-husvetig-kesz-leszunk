package com.codecool.shop.dao;

import com.codecool.shop.model.User;
import com.codecool.shop.model.ShoppingCart;

public interface ShoppingCartDao {
    ShoppingCart cartForUser(User user);
}
