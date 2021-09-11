package co.com.poli.cloud.serviceuser.services;

import co.com.poli.cloud.serviceuser.entities.User;

import java.util.List;

public interface UserService {
    void save(User user);

    Boolean delete(User user);

    List<User> findAll();

    User findById(Long id);

}
