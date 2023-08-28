package com.portfolio.CozyConnection.controller;

import com.portfolio.CozyConnection.collection.User;
//import com.portfolio.CozyConnection.service.UserService;
import com.portfolio.CozyConnection.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/")
    public String save(@RequestBody User user){
     userServiceImpl.save(user);
        return user.getUserId();
    }
}
