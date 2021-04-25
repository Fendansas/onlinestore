package com.github.fendansas.onlinestore.servise.impl;

import com.github.fendansas.onlinestore.domain.Product;
import com.github.fendansas.onlinestore.repo.ProductRepo;
import com.github.fendansas.onlinestore.servise.ProductService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class JPAProductService implements ProductService, InitializingBean {
    @Autowired
    private ProductRepo repo;

    @Override
    public List<Product> getProducts() {
        return repo.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        return repo.getOne(id);
    }

    @Override
    public void saveProduct(Product product) {
        repo.save(product);
    }

    //продукт и количество продуктов в заказе.
    //Убеждаемся что > 0 и что количесство в заказе => кол-во на складе
    @Override
    public Boolean isProductInStock(Product product, Integer quantityInOrder) {
        if (product.getInStockQuantity() > 0 && product.getInStockQuantity() >= quantityInOrder) {
            return true;
        }
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }
}
