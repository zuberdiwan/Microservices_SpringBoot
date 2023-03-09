package com.microservices.HotelService.controller;

import com.microservices.HotelService.entities.Hotel;
import com.microservices.HotelService.services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelServices hotelServices;

    @PostMapping
    public ResponseEntity<Hotel> SaveHotels(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelServices.createHotel(hotel));

    }

    @GetMapping("{hotelId}")
    public ResponseEntity<Hotel> getHotelsById(@PathVariable String hotelId){
            return  ResponseEntity.status(HttpStatus.OK).body(hotelServices.getSingleHotel(hotelId));
    }
    @GetMapping
    public  ResponseEntity<List<Hotel>> getAllHotels(){
        return  ResponseEntity.status(HttpStatus.OK).body(hotelServices.getAllHotels());
    }
}
