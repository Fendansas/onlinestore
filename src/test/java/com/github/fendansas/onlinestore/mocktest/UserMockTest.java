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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserMockTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepo userRepo;

    User user = new User("sas", "ses", "fendansa@mail.ru",
            "+37644584874", new Address(),
            null, null);

    User user1 = new User("s2as", "se2s",
            "fe2ndansa@mail.ru", "+376244584874",
            new Address(), null, null);


    @Test
    public void getUserTest() {
        List list = new ArrayList();
        list.add(user);
        list.add(user1);
        when(userRepo.findAll()).thenReturn(list);
        assertEquals(2, userService.getUsers().size());
        assertEquals(userService.getUsers().get(0), user);
    }

    @Test
    public void getUserById() {
        List list = new ArrayList();
        list.add(user);
        list.add(user1);
        Integer id = user.getId();
        when(userRepo.getOne(id)).thenReturn(user);
        User userT = userService.getUser(id);
        assertEquals(userT, user);
        assertEquals(userT.getEmail(), user.getEmail());
    }

    @Test
    public void addUser() {
        List list = new ArrayList();
        list.add(user);
        list.add(user1);
        userRepo.saveAll(list);
        when(userRepo.findAll()).thenReturn(list);
        assertEquals(2, userService.getUsers().size());

    }


}
