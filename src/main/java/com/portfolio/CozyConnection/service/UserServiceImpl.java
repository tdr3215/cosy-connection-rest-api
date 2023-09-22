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
    public void save(User user) {
         userRepository.save(user);
        System.out.println("New User Added!");
    }


    @Override
    public List<User> findAll() {

        return userRepository.findAll().stream().toList();
    }

    @Override
    public void removeUser(String id) {
       User userToBeDeleted = userRepository.findById(id).orElseThrow();

       userRepository.delete(userToBeDeleted);
    }

    @Override
    public List<User> findUserByAge(Integer min, Integer max) {
        try {
            return userRepository.findUserByAgeBetween(min, max);
        } catch (Exception e){
           System.out.println(e.getMessage());
        }

        return null;


    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User updateUser(String id, User userData) {
        User userToBeUpdated = findUserById(id);
        userToBeUpdated.setFirstname(userData.getFirstname());
        userToBeUpdated.setLastname(userData.getLastname());
        userToBeUpdated.setAge(userData.getAge());
        userToBeUpdated.setEmail(userData.getEmail());
        userRepository.save(userToBeUpdated);
        return userToBeUpdated;
    }


}
