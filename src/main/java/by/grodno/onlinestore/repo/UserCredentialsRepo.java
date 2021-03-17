package by.grodno.onlinestore.repo;

import by.grodno.onlinestore.domain.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepo extends JpaRepository<UserCredentials, Integer> {
}
