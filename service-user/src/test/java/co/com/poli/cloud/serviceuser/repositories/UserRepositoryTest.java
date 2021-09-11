package co.com.poli.cloud.serviceuser.repositories;

import co.com.poli.cloud.serviceuser.entities.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void FindByLastName() {
        User user = User.builder()
                .name("Andres")
                .lastName("Vasquez")
                .build();

        userRepository.save(user);
        List<User> users = userRepository.findUserByLastName(user.getLastName());

        Assertions.assertThat(users.size()).isEqualTo(2);
    }
}
