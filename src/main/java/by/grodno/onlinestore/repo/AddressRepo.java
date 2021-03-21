package by.grodno.onlinestore.repo;

import by.grodno.onlinestore.domain.Address;
import by.grodno.onlinestore.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
