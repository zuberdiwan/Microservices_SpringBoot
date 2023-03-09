package com.microservices.UserService.controller;

import com.microservices.UserService.entities.User;
import com.microservices.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> CreateUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUsers(user));
    }

    @GetMapping("/{userId}")
    public  ResponseEntity<User> GetSingleUser(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getSingleUser(userId));
    }

    @GetMapping
    public  ResponseEntity<List<User>> getAllUsers(){
        return  ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());
    }
}
