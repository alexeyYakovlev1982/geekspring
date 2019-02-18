package com.geekbrains.controllers;

import com.geekbrains.entities.Product;
import com.geekbrains.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    // http://localhost:8189/app/products/showForm
    @RequestMapping("/showForm")
    public String showSimpleForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "product-form";
    }

    // http://localhost:8189/app/products/processForm
    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product) {
        System.out.println(product.getId() + " " + product.getTitle() + " " + product.getCost());
        return "product-form-result";
    }

    // http://localhost:8189/app/products/allProducts
    @GetMapping(path="/allProducts")
    public String showAllProducts(Model model) {
//        List<Product> products = productsService.getAllProducts();
//        return products;
        model.addAttribute("products", productsService.getAllProducts());
        return "allProducts";
    }

}
