package com.portfolio.CozyConnection.service;

import com.portfolio.CozyConnection.collection.User;

import java.util.List;


public interface UserService {
    User findUserByFirstName(String firstName);

    void save(User user);

    List<User> findAll();

    void removeUser(String id);

    List<User> findUserByAge(Integer min, Integer max);

    User findUserById(String id);

    User updateUser(String id, User userData);
}
