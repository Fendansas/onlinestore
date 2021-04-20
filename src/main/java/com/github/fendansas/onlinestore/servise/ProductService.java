package com.github.fendansas.onlinestore.servise;

import com.github.fendansas.onlinestore.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProductById(Integer id);

    void addProduct(Product product);

    Boolean isProductInStock(Integer id, Integer inStockQuantity);


}
