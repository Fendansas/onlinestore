package com.github.fendansas.onlinestore.servise.impl;

import com.github.fendansas.onlinestore.domain.User;
import com.github.fendansas.onlinestore.repo.UserRepo;
import com.github.fendansas.onlinestore.servise.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JPAUserService implements UserService, InitializingBean {

    @Autowired
    private UserRepo userRepo;

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUser(Integer id) {
        return userRepo.getOne(id);
    }

    @Override
    public void addUser(List<User> users) {
        userRepo.saveAll(users);

    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);

    }

    @Override
    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(userRepo.findByEmail(email));
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
