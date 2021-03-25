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
        return  repo.findAll();
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
