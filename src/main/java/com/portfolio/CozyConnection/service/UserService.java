package com.portfolio.CozyConnection.service;

import com.portfolio.CozyConnection.collection.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    void save(User user);

    List<User> findAll();

    void removeUser(String id);

    Optional<User> findUserById(String id);

    Optional<User> findUserByFirstName(String firstName);

    Optional<List<User>> findUserByAge(Integer min, Integer max);

    User updateUser(String id, User userData);
}
