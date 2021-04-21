package com.github.fendansas.onlinestore.repo;

import com.github.fendansas.onlinestore.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByName(String name);

}
