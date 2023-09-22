package com.portfolio.CozyConnection.controller;

import com.portfolio.CozyConnection.collection.User;
import com.portfolio.CozyConnection.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cozy-api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    // POST http://localhost:8080/cozy-api/users/
    @PostMapping("/")
    public String save(@RequestBody User user){
     userServiceImpl.save(user);
        return user.getUserId();
    }

    // GET http://localhost:8080/cozy-api/users/
    @GetMapping("/")
    public List<User> findAllUsers(){
        return userServiceImpl.findAll();
    }

    //GET http://localhost:8080/cozy-api/users/Bob
    @GetMapping("/{firstname}")
    public User findUserByFirstName(@PathVariable String firstname){
       return userServiceImpl.findUserByFirstName(firstname);

    }

    //GET http://localhost:8080/cozy-api/users/46
  @GetMapping("/age")
  public List<User> getUserByAge(
          @RequestParam Integer min,
          @RequestParam Integer max
  ){
return userServiceImpl.findUserByAge(min,max);
  }


//  PUT http://localhost:8080/users/1
    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User userData){

        return userServiceImpl.updateUser(id,userData);
    }

    // DELETE http://localhost:8080/users/1
    @DeleteMapping("/users/{id}")
    public Integer deleteUser(@PathVariable String id){
        try {
            userServiceImpl.removeUser(id);
        }
      catch (Exception error){
          throw new RuntimeException();
      }
        return 1;
    }
//@GetMapping("/search")
//    public Page<User> searchUser(){
////return new Page();
//    }


}
