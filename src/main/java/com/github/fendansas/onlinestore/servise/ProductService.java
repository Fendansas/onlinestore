package com.github.fendansas.onlinestore.servise;

import com.github.fendansas.onlinestore.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProductById(Integer id);

    void saveProduct(Product product);

    Boolean isProductInStock(Product product, Integer quantityInOrder);


}
