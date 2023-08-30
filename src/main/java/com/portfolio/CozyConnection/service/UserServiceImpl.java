package com.portfolio.CozyConnection.service;

import com.portfolio.CozyConnection.collection.User;
import com.portfolio.CozyConnection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public String save(User user) {
         userRepository.save(user);
        return user.getUserId();
    }
@Override
    public List<User> findAll() {

        return userRepository.findAll().stream().toList();
    }
}
