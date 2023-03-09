package com.microservices.HotelService.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "micro_hotels")
public class Hotel {
    @Id
    @Column(name = "Hotel_Id")
    private String hotelId;
    @Column(name = "Hotel_Name")
    private String name;
    @Column(name = "Hotel_Location")
    private  String location;
    @Column(name = "Hotel_About")
    private  String about;

}
