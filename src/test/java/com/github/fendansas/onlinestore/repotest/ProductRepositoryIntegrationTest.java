package com.github.fendansas.onlinestore.repotest;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import com.github.fendansas.onlinestore.repo.ProductRepo;
import com.github.fendansas.onlinestore.domain.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryIntegrationTest {

    @Autowired
    private ProductRepo repo;

    @BeforeEach
    public void setUpDB() {
//        Product ak104 = new Product("ak104", "sas", new BigDecimal(1500), 5);
//        Product ak105 = new Product("ak105", "sas1", new BigDecimal(1510), 5);
//        repo.save(ak104);
//        repo.save(ak105);
    }

    @Test
    public void testCreate_readByUserName() {
//        // WHEN
//        Product findByName = repo.findByName("ak104");
//
//        // THEN
//        assertNotNull(findByName);
//        assertEquals("ak104", findByName.getName());
    }

    @Test
    public void testCreate_findAll() {
//        // WHEN
//        List products = repo.findAll();
//
//        // THEN
//        assertNotNull(products);
//        assertEquals(2, products.size());
    }

}
