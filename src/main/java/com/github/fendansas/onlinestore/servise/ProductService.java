package com.github.fendansas.onlinestore.servise;

import com.github.fendansas.onlinestore.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProductById(Integer id);

    void saveProduct(Product product);

    Boolean isProductInStock(Product product, Integer quantityInOrder);

    //Page Products
    Page<Product> getProductPage(Integer pageNum,
                                 Integer size,
                                 String fieldName,
                                 Sort.Direction direction);


}
