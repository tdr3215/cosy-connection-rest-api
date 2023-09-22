package com.portfolio.CozyConnection.service;

import com.portfolio.CozyConnection.collection.User;
import com.portfolio.CozyConnection.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<User> findUserByFirstName(String firstName) {
        return findAll()
                .stream()
                .filter(user -> user.getFirstname().equals(firstName))
                .findFirst();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
        System.out.println("New User Added!");
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();

    }

    @Override
    public void removeUser(String id) {
        User userToBeDeleted = userRepository.findById(id).orElseThrow();

        userRepository.delete(userToBeDeleted);
    }

    @Override
    public Optional<List<User>> findUserByAge(Integer min, Integer max) {
        return userRepository.findUserByAgeBetween(min, max);
    }

    @Override
    public Optional<User> findUserById(String id) {
        return userRepository.findById(id);


    }

    @Override
    public User updateUser(String id, User userData) {
        Optional<User> userToBeUpdated = findUserById(id);
        User updatedUser = userToBeUpdated.map(u -> {

            u.setFirstname(userData.getFirstname());
            u.setLastname(userData.getLastname());
            u.setAge(userData.getAge());
            u.setEmail(userData.getEmail());
            return u;
        }).orElseThrow();


        userRepository.save(updatedUser);
        return updatedUser;
    }


}
