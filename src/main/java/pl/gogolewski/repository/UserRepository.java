package pl.gogolewski.repository;

import org.springframework.data.repository.CrudRepository;
import pl.gogolewski.entity.User;

import java.util.Collection;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    User findOne(Long id);
    Collection<User>findAll();
    User save(User newUser);
    void delete(Long userId);
}