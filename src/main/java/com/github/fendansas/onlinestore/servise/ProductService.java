package com.github.fendansas.onlinestore.servise;

import com.github.fendansas.onlinestore.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    void addProduct(List<Product> products);
}
