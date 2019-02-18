package com.geekbrains.repositories;

import com.geekbrains.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductsRepository {

    List<Product> productList ;

    @PostConstruct
    public void init(){
        productList = new ArrayList<>();
        productList.add(new Product(1L, "TV1", 15000));
        productList.add(new Product(2L, "TV2", 25000));
        productList.add(new Product(3L, "TV3", 35000));
    }


    public void addProduct(Product product){
        productList.add(product);
    }

    public Product findOneById(Long id){
        for (Product product : productList) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> findAll() {
        return productList;
    }

    public Product save(Product product){
        productList.add(product);
        return product;
    }
}
