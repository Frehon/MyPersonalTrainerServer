package pl.gogolewski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gogolewski.dto.UserDTO;
import pl.gogolewski.repository.UserRepository;
import pl.gogolewski.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User getUserById(Long userId) {
        return userRepository.findOne(userId);
    }

    @Transactional
    public User getUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

    @Transactional
    public User saveUser(User user) { return userRepository.save(user);}

    @Transactional
    public User updateUser(User user) throws IllegalArgumentException{
        System.out.println("USer boniek " + user.getId());
        User oldUser = userRepository.findOne(user.getId());

        return saveUser(UserDTO.compareUsers(oldUser,user));
    }

    @Transactional
    public void deleteUser(User user) {userRepository.delete(user);}
}
