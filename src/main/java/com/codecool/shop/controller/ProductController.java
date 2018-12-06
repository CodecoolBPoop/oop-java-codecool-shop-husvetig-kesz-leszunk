package com.codecool.shop.controller;

import com.codecool.shop.dao.ProductCategoryDao;
import com.codecool.shop.dao.ProductDao;
import com.codecool.shop.dao.SupplierDao;
import com.codecool.shop.dao.implementation.ProductCategoryDaoMem;
import com.codecool.shop.dao.implementation.ProductDaoMem;
import com.codecool.shop.config.TemplateEngineUtil;
import com.codecool.shop.model.ShoppingCart;
import com.codecool.shop.dao.implementation.SupplierDaoMem;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = {"/"})
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductDao productDataStore = ProductDaoMem.getInstance();
        ProductCategoryDao productCategoryDataStore = ProductCategoryDaoMem.getInstance();
        SupplierDao supplierDataStore = SupplierDaoMem.getInstance();

//        Map params = new HashMap<>();
//        params.put("category", productCategoryDataStore.find(1));
//        params.put("products", productDataStore.getBy(productCategoryDataStore.find(1)));

        TemplateEngine engine = TemplateEngineUtil.getTemplateEngine(req.getServletContext());
        WebContext context = new WebContext(req, resp, req.getServletContext());
//        context.setVariables(params);
        context.setVariable("recipient", "World");
        context.setVariable("allproduct", productCategoryDataStore.getAll());
        context.setVariable("allsupplier", supplierDataStore.getAll());
        if (req.getParameter("category") != null) {
            context.setVariable("category", productCategoryDataStore.find(Integer.parseInt(req.getParameter("category"))));
            context.setVariable("products", productDataStore.getBy(productCategoryDataStore.find(Integer.parseInt(req.getParameter("category")))));
        } else if (req.getParameter("supplier") != null) {
            context.setVariable("category", supplierDataStore.find(Integer.parseInt(req.getParameter("supplier"))));
            context.setVariable("products", productDataStore.getBy(supplierDataStore.find(Integer.parseInt(req.getParameter("supplier")))));
        } else {
            context.setVariable("allproduct", productCategoryDataStore.getAll());
            context.setVariable("products", productDataStore.getAll());
        }
        engine.process("product/index.html", context, resp.getWriter());

        String itemToShoppingCart = req.getParameter("itemid-add");

        if (itemToShoppingCart != null) {
            int itemToShoppingCartId = Integer.parseInt(itemToShoppingCart);
            ShoppingCart.shoppingCartList.add(productDataStore.find(itemToShoppingCartId));
        }
    }

}
