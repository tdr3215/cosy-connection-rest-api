package com.portfolio.CozyConnection.service;

import com.portfolio.CozyConnection.collection.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User findUserByFirstName(String firstName);

    String save(User user);
//    void saveAll(User... users);

    List<User> findAll();
}
