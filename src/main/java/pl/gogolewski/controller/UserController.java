package pl.gogolewski.controller;

import com.sun.istack.internal.NotNull;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gogolewski.dto.UserDTO;
import pl.gogolewski.entity.User;
import pl.gogolewski.service.UserService;

@RestController
@CommonsLog
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(@NotNull UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(
            value = "/api/users",
            method = RequestMethod.GET ,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<User>> getAllUsers(){
        Iterable<User> allUsers = userService.getAllUsers();
        if(allUsers == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allUsers , HttpStatus.MULTI_STATUS.OK);
    }

    @RequestMapping(
            value = "/api/user/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserById(@PathVariable("id") Long Id){
        User u =  userService.getUserById(Id);
        if(u == null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(u , HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/user",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createNewUser(@RequestBody UserDTO u){
        User newUser = new User.UserBuilder()
                .userName(u.getUserName())
                .birthDate(u.getBirthDate())
                .gender(u.getGender())
                .email(u.getEmail())
                .passwordHash(u.getPasswordHash())
                .weight(u.getWeight())
                .height(u.getHeight())
                .dietType(u.getDietType())
                .activityFactor(u.getActivityFactor())
                .caloriesAmount(u.getCaloriesAmount())
                .proteinAmount(u.getProteinAmount())
                .carbsAmount(u.getCarbsAmount())
                .fatAmount(u.getFatAmount())
                .build();
        try {
            userService.saveUser(newUser);
            return new ResponseEntity<>(newUser,HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "api/user/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody UserDTO u){
        try {
            User updatedUser = UserDTO.convert_DTO_USER(u);
            userService.saveUser(updatedUser);
            return new ResponseEntity<>(updatedUser,HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "api/user/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        User userToDelete = userService.getUserById(id);
        if (userToDelete != null){
            userService.deleteUser(userToDelete);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}