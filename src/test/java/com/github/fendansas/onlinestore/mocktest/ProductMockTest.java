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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductMockTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepo productRepo;

    //repo.findAll()
    @Test
    public void getProductTest() {
//        when(productRepo.findAll()).thenReturn(Stream
//                .of(new Product("1", "212", new BigDecimal(12), 3)
//                        , new Product("2", "ewew", new BigDecimal(14), 5))
//                .collect(Collectors.toList()));
//        assertEquals(2, productService.getProducts().size());
    }

    @Test
    public void getProductTest2() {
//        Product product = new Product("1", "212", new BigDecimal(12), 3);
//        Product product2 = new Product("21", "2212", new BigDecimal(22), 23);
//        List list = new ArrayList();
//        list.add(product);
//        when(productRepo.findAll()).thenReturn(list);
//        assertEquals(1, productService.getProducts().size());
//        assertEquals(productService.getProducts().get(0), product);
    }

    @Test //test
    public void getProductById() {
//        Product product = new Product(1, "1", "212", new BigDecimal(12), 3);
//        Product product2 = new Product(2, "12", "2122", new BigDecimal(122), 23);
//        List list = new ArrayList();
//        list.add(product);
//        list.add(product2);
//        productRepo.save(product);
//        when(productService.getProductById(1)).thenReturn(product);
//        Product product1 = productService.getProductById(1);
//        assertEquals(product.getName(), product1.getName());
//        assertEquals(1, product1.getId());
//        assertNotNull(product1);
    }

}
