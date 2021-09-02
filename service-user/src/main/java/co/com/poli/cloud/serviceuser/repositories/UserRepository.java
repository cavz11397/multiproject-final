package co.com.poli.cloud.serviceuser.repositories;

import co.com.poli.cloud.serviceuser.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
