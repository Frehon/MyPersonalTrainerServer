package pl.gogolewski.repository;

import org.springframework.data.repository.CrudRepository;
import pl.gogolewski.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

}