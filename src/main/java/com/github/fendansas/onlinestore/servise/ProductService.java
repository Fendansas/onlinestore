package com.github.fendansas.onlinestore.servise;

import com.github.fendansas.onlinestore.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProduct(Integer id);

    void addProduct(List<Product> products);
}
