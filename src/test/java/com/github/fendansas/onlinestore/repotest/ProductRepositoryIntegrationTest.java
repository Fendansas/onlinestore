package com.github.fendansas.onlinestore.repotest;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

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
        Product ak104 = new Product("ak104", "sas", new BigDecimal(1500), 5);
        repo.save(ak104);
    }

    @Test
    public void testCreate_readByUserName() {
        // WHEN
        Product findByName = repo.findByName("ak104");

        // THEN
        assertNotNull(findByName);
        assertEquals("ak104", findByName.getName());
    }



}
