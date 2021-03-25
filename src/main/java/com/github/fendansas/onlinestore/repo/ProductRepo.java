package com.github.fendansas.onlinestore.repo;


import com.github.fendansas.onlinestore.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    public Product findByName(String name);
}
