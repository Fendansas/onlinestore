package com.github.fendansas.onlinestore.mocktest;

import com.github.fendansas.onlinestore.domain.Address;
import com.github.fendansas.onlinestore.domain.User;
import com.github.fendansas.onlinestore.repo.UserRepo;
import com.github.fendansas.onlinestore.servise.UserService;
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
public class UserMockTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepo userRepo;

//    @Test
//    public void getProductTest2() {
//        Product product = new Product("1", "212", new BigDecimal(12), 3);
//        Product product2 = new Product("21", "2212", new BigDecimal(22), 23);
//        List list = new ArrayList();
//        list.add(product);
//        when(productRepo.findAll()).thenReturn(list);
//        assertEquals(1, productService.getProducts().size());
//        assertEquals(productService.getProducts().get(0), product);
//    }
    @Test
    public void getUserTest(){
        User user = new User("sas","ses","fendansa@mail.ru",
                "+37644584874",new Address(),
                null, null);
        User user1 = new User("s2as","se2s",
                "fe2ndansa@mail.ru","+376244584874",
                new Address(),null, null);
//        List list = new ArrayList();
//        list.add(user);
//        list.add(user1);
//        when(userRepo.findAll()).thenReturn(list);
//        assertEquals(2,userService.getUsers().size());
//        assertEquals(userService.getUsers().get(0),user);

    }


}
