package com.example.lesson41_petstore_swagger.controller;

import com.example.lesson41_petstore_swagger.entity.User;
import com.example.lesson41_petstore_swagger.repository.UserRepository;
import com.example.lesson41_petstore_swagger.service.UserService;
import com.example.lesson41_petstore_swagger.service.serviceSpringDataJPA.UserServiceSpringDataJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceSpringDataJPA userService;

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        if (userService.addUser(user)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        }
    }

    @PostMapping("/createWithList")
    public ResponseEntity<List<User>> createWithList(@Valid @RequestBody List<User> users){
        if (userService.addListOfUsers(users)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> findByUsername(@PathVariable String  username){
        Optional<User> userByUsername = userService.findUserByUsername(username);
        if (userByUsername.isPresent()){
            return ResponseEntity.ok(userByUsername.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        if (allUsers.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else {
            return ResponseEntity.ok(allUsers);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<User> update(@Valid @RequestBody User user){
        if (userService.updateUser(user)){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable long id){
        if (userService.deleteUserById(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }







    //without Spring Data JPA
//
//    @Autowired
//    private UserService userService;
//
//    @PostMapping
//    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
//        if (userService.addUser(user)){
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
//    }
//
//    @PostMapping("/createWithList")
//    public ResponseEntity<List<User>> createWithList(@Valid @RequestBody List<User> users){
//        if (users.isEmpty()){
//            return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
//        }else{
//            userService.addListOfUsers(users);
//            return new ResponseEntity<>(HttpStatus.OK);
//        }
//    }
//
//    @GetMapping("/{username}")
//    public ResponseEntity<User> findByUsername(@PathVariable String  username){
//        return userService.findUserByUsername(username);
//    }
//
//    @GetMapping("/findAll")
//    public ResponseEntity<List<User>> findAllUsers(){
//        List<User> allUsers = userService.getAllUsers();
//        if (allUsers.isEmpty()){
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }else {
//            return ResponseEntity.ok(allUsers);
//        }
//    }
//
//
//    @PutMapping("/update")
//    public ResponseEntity<User> update(@Valid @RequestBody User user){
//        if (userService.updateUser(user)){
//            return new ResponseEntity<>(HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<User> delete(@PathVariable long id){
//        if (userService.deleteUserById(id)){
//            return new ResponseEntity<>(HttpStatus.OK);
//        }else{
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }

}
