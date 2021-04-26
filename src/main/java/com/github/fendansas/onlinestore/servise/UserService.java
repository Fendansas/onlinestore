package com.github.fendansas.onlinestore.servise;

import com.github.fendansas.onlinestore.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();

    User getUser(Integer id);

    void addUser(List<User> users);

    void saveUser(User user);

    void deleteUser(User user);

    Optional<User> findByEmail(String email);

}
