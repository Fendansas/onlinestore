package by.grodno.onlinestore.repo;


import by.grodno.onlinestore.domain.OrderItem;
import by.grodno.onlinestore.domain.UserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {
}
