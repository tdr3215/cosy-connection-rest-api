package com.portfolio.CozyConnection.service;

import com.portfolio.CozyConnection.collection.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    String save(User user);

    List<User> findAll();
}
