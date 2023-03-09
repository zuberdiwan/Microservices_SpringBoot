package com.microservices.UserService.repository;

import com.microservices.UserService.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    //custome methods
}
