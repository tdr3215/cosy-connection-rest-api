package com.portfolio.CozyConnection.service;

import com.portfolio.CozyConnection.collection.User;
import com.portfolio.CozyConnection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

@Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
public User findUserByFirstName(String firstName){
       return findAll().stream()
                .filter(u->u.getFirstname().equals(firstName))
                .findFirst()
                .orElseThrow();
}

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
