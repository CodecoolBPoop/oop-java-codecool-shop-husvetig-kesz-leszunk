package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.*;
import java.math.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJDBC implements ProductDao {


    @Override
    public void add(Product product) {

    }

    @Override
    public Product find(int id) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    /* tring query = "SELECT * FROM todos;";

        List<Product> resultList = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ){
            while (resultSet.next()){
                Product actTodo = new Product(resultSet.getString("title"),
                        resultSet.getString("id"),
                        Status.valueOf(resultSet.getString("status")));
                resultList.add(actTodo);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

*/
    @Override
    public List<Product> getBy(Supplier supplier) {
        return null;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        return null;
    }
}
