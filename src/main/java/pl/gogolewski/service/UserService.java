package pl.gogolewski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gogolewski.dto.UserDTO;
import pl.gogolewski.repository.UserRepository;
import pl.gogolewski.entity.User;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findOne(userId);
    }

    public User getUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

    public User saveUser(User user) {return userRepository.save(user);}

    public User updateUser(User user) throws IllegalArgumentException{
        User oldUser = userRepository.findOne(user.getId());
        return saveUser(UserDTO.compareUsers(oldUser,user));
    }

    public void deleteUser(Long userToDeleteId) {userRepository.delete(userToDeleteId);}
}