package co.com.poli.cloud.serviceuser.repositories;

import co.com.poli.cloud.serviceuser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findUserByLastName(String lastname);
}
