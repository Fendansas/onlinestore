package com.github.fendansas.onlinestore.mocktest;


import com.github.fendansas.onlinestore.domain.Product;
import com.github.fendansas.onlinestore.repo.ProductRepo;
import com.github.fendansas.onlinestore.servise.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductMockTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepo productRepo;

    @Test
    public void getProductTest() {
        when(productRepo.findAll()).thenReturn(Stream
                .of(new Product("1", "212", new BigDecimal(12), 3)
                        , new Product("2", "ewew", new BigDecimal(14), 5))
                .collect(Collectors.toList()));
        assertEquals(2, productService.getProducts().size());
    }


}
