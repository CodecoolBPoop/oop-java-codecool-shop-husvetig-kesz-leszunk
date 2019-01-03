package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.implementation.jdbc.SupplierDaoJdbc;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import java.sql.*;
import java.math.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoJDBC implements ProductDao {
    private static final String DATABASE = "jdbc:postgresql://localhost:5432/webshop";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "postgres";

    private static ProductDaoJDBC instance = null;

    ProductCategory productCategory;
    Supplier supplier = new Supplier("Hehe", "haha");


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

        String query = "SELECT * FROM product;";

        List<Product> resultList = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)
        ){
            while (resultSet.next()){
                String currencyString = "USD";
                ProductCategory productCategory = new ProductCategory("name", "asd", "ad");
                Product actTodo = new Product(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("default_price"),
                        currencyString,
                        resultSet.getString("description"),
                        productCategory,
                        supplier,
                        resultSet.getInt("category_id"),
                        resultSet.getInt("supplier_id"));
                resultList.add(actTodo);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }


    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                DATABASE,
                DB_USER,
                DB_PASSWORD);
    }

    private void executeQuery(String query) {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
        ) {
            statement.execute(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getBy(Supplier supplier) {
        String query = "SELECT * FROM product JOIN supplier ON product.supplier_id = supplier.id WHERE supplier.id = '" + supplier.getId() + "';";

        List<Product> resultList = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ){
            while (resultSet.next()){
                String currencyString = "USD";
                ProductCategory productCategory = new ProductCategory("name", "asd", "ad");
                Product product = new Product(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("default_price"),
                        currencyString,
                        resultSet.getString("description"),
                        productCategory,
                        supplier,
                        resultSet.getInt("category_id"),
                        resultSet.getInt("supplier_id"));
                resultList.add(product);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    @Override
    public List<Product> getBy(ProductCategory productCategory) {
        String query = "SELECT * FROM product JOIN product_category on product.category_id = product_category.id WHERE product_category.id = '" + productCategory.getId() + "';";

        List<Product> resultList = new ArrayList<>();
        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
        ){
            while (resultSet.next()){
                String currencyString = "USD";
                ProductCategory productCategory1 = new ProductCategory("name", "asd", "ad");
                Product product = new Product(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getFloat("default_price"),
                        currencyString,
                        resultSet.getString("description"),
                        productCategory1,
                        supplier,
                        resultSet.getInt("category_id"),
                        resultSet.getInt("supplier_id"));
                resultList.add(product);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

    public static ProductDaoJDBC getInstance() {
        if (instance == null) {
            instance = new ProductDaoJDBC();
        }
        return instance;
    }
}
