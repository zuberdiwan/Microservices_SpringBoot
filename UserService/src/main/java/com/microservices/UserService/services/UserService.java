package com.microservices.UserService.services;

import com.microservices.UserService.entities.User;

import java.util.List;

public interface UserService {
    //All Methods
    //save users
    User saveUsers(User user);

    //Get All User
    List<User> getAllUser();

    //Get Single User
    User getSingleUser(String userId);

    //update delete pending
}
