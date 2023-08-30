package com.portfolio.CozyConnection.controller;

import com.portfolio.CozyConnection.collection.User;
//import com.portfolio.CozyConnection.service.UserService;
import com.portfolio.CozyConnection.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/users")
    public String save(@RequestBody User user){
     userServiceImpl.save(user);
        return user.getUserId();
    }

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userServiceImpl.findAll();
    }
}
