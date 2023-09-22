package com.portfolio.CozyConnection.controller;

import com.portfolio.CozyConnection.collection.User;
import com.portfolio.CozyConnection.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cozy-api/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    // POST http://localhost:8080/cozy-api/users/
    @PostMapping("/")
    public ResponseEntity<User> save(@RequestBody User user){
     userServiceImpl.save(user);
        return new ResponseEntity<>(user,HttpStatus.CREATED);
    }

    // GET http://localhost:8080/cozy-api/users/
    @GetMapping("/")
    public ResponseEntity<List<User>> findAllUsers(){
        return new ResponseEntity<>(userServiceImpl.findAll(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findUserByID(@PathVariable String id){
        return new ResponseEntity<>(userServiceImpl.findUserById(id),HttpStatus.OK);
    }

    // http://localhost:8080/cozy-api/users?firstname=Andromeda
    @RequestMapping(method =RequestMethod.GET)
    public ResponseEntity<User> findUserByFirstName(@RequestParam(value = "firstname") String firstname){
       return new ResponseEntity<>(userServiceImpl.findUserByFirstName(firstname),HttpStatus.OK);

    }

    @RequestMapping(method =RequestMethod.GET,path = "/age")
    public ResponseEntity<List<User>> findUserByAge(@RequestParam(value = "min") Integer min,@RequestParam(value = "max") Integer max){
        return new ResponseEntity<>(userServiceImpl.findUserByAge(min,max),HttpStatus.OK);

    }

    //GET http://localhost:8080/cozy-api/users/46
//  @GetMapping("/searchByAge")
//  public ResponseEntity<List<User>> getUserByAge(
//          @RequestParam(value = "min") Integer min,
//          @RequestParam(value = "max") Integer max
//  )
//  {
//        return new ResponseEntity<>(userServiceImpl.findUserByAge(min,max),HttpStatus.OK);
//  }


//  PUT http://localhost:8080/users/1
    @PutMapping("/{id}")
    public  ResponseEntity<User> updateUser(@PathVariable String id,
                           @RequestBody User userData)
    {

        return new ResponseEntity<>(userServiceImpl.updateUser(id,userData),HttpStatus.OK);
    }

    // DELETE http://localhost:8080/users/1
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable String id){
        try {
            userServiceImpl.removeUser(id);
        }
      catch (Exception error){
          throw new RuntimeException();
      }
        return new ResponseEntity<>(id,HttpStatus.OK);
    }
//@GetMapping("/search")
//    public Page<User> searchUser(){
////return new Page();
//    }


}
