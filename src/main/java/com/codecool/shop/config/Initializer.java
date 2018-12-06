package com.codecool.shop.config;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import com.codecool.shop.model.Product;
import com.codecool.shop.model.ProductCategory;
import com.codecool.shop.model.Supplier;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Initializer implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

        //setting up a new supplier
        Supplier amazon = new Supplier("Nubian Design-Collective", "Digital content and services");
        supplierDataStore.add(amazon);
        Supplier lenovo = new Supplier("Serv-O-Droids", "Droids");
        supplierDataStore.add(lenovo);

        //setting up a new product category
        ProductCategory robotics = new ProductCategory("Robotics", "Hardware", "A tablet computer, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(robotics);
        ProductCategory cellphone = new ProductCategory("Cellphone", "Hardware", "A cellphone, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(cellphone);
        ProductCategory spaceShipPart = new ProductCategory("Spaceship", "Hardware", "A cellphone, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(spaceShipPart);
        ProductCategory weapon = new ProductCategory("Weapon", "Weapon", "A cellphone, commonly shortened to tablet, is a thin, flat mobile computer with a touchscreen display.");
        productCategoryDataStore.add(weapon);

        //setting up products and printing it
        productDataStore.add(new Product("S-5 heavy blaster pistol", 1499.9f, "USD", "A versatile weapon with a heavy wooden gripstock and twin scopes for sighting and rangefinding. ", weapon, amazon));
        productDataStore.add(new Product("Bionic Arm", 2490.9f, "USD", "An affordable, advanced and intuitive bionic arm. Adjustable finger bone crack sound effect. Grab Capable of achieving speeds over 700 kilometers per hour,it fast.", robotics, lenovo));
        productDataStore.add(new Product("Custom Build Podracer", 5990, "USD", "A one-man cockpit that pulled along by two engines. Capable of achieving speeds over 900 kilometers per hour, sometimes fails at start.", spaceShipPart, amazon));
        productDataStore.add(new Product("Spaceship Engine", 11990, "USD", "Spaceship engine at it's finest. Good condition, fall in price.", spaceShipPart, amazon));
        productDataStore.add(new Product("T-14 hyperdrive generator", 8990, "USD", "A propulsion system that allows a starship to reach lightspeed.", spaceShipPart, amazon));
        productDataStore.add(new Product("Pit Droid", 2990, "USD", "Cheap and durable repair droids. Tap their 'nose' to fold into compact form. ", robotics, lenovo));

    }
}
