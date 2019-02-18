package com.geekbrains.services;

import com.geekbrains.entities.Product;
import com.geekbrains.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setStudentsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product getStudentById(Long id) {
        Product product = productsRepository.findOneById(id);
        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> products = productsRepository.findAll();
        return products;
    }

    public Product saveProduct(Product product) {
        if (product == null) {
            return null;
        } else {
            return productsRepository.save(product);
        }
    }

}
