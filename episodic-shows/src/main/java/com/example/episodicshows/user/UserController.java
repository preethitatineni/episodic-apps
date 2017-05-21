package com.example.episodicshows.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by trainer6 on 5/20/17.
 */
@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;


    @GetMapping("/users")
    public List<User> getUsers(){
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }


}
