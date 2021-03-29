package com.github.fendansas.onlinestore.servise;

import com.github.fendansas.onlinestore.domain.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUser(Integer id);

    void addUser(List<User> user);

    void saveUser(User user);


}
