package com.portfolio.CozyConnection.controller;

import com.portfolio.CozyConnection.collection.User;
import com.portfolio.CozyConnection.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cozy-api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/")
    public String save(@RequestBody User user){
     userServiceImpl.save(user);
        return user.getUserId();
    }

    @GetMapping("/")
    public List<User> findAllUsers(){
        return userServiceImpl.findAll();
    }

    @GetMapping("/{firstname}")
    public User findUserByFirstName(@PathVariable String firstname){
       return userServiceImpl.findUserByFirstName(firstname);

    }

}
