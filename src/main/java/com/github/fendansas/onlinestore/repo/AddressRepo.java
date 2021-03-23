package com.github.fendansas.onlinestore.repo;

import com.github.fendansas.onlinestore.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
