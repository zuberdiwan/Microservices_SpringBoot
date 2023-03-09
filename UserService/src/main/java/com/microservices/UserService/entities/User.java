package com.microservices.UserService.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "micro_users")
public class User {
    @Id
    @Column(name = "ID")
    private String userid;
    @Column(name = "NAME")
    private  String name;
    @Column(name = "EMAIL")
    private  String email;
    @Column(name = "ABOUT")
    private  String about;

    @Transient
    private List<Ratings> ratings=new ArrayList<>();
}
