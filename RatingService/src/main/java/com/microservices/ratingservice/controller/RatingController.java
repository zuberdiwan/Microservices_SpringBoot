package com.microservices.ratingservice.controller;

import com.microservices.ratingservice.entities.Rating;
import com.microservices.ratingservice.service.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingServices ratingServices;

    @PostMapping
    public ResponseEntity<Rating> CreateRatings(@RequestBody Rating rating){
        return  ResponseEntity.status(HttpStatus.CREATED).body(ratingServices.createRatings(rating));
    }

    @GetMapping
    public ResponseEntity<List<Rating>> GetAllRatings(){
        return  ResponseEntity.status(HttpStatus.OK).body(ratingServices.getAllRatings());
    }

    @GetMapping("/users/{userId}")
    public  ResponseEntity<List<Rating>> GetRatingsByUserId(@PathVariable  String userId){
        return  ResponseEntity.status(HttpStatus.OK).body(ratingServices.getRatingsByUser(userId));
    }

    @GetMapping("/hotel/{hotelId}")
    public  ResponseEntity<List<Rating>> GetRatingsByHotelId(@PathVariable String hotelId) {
        return  ResponseEntity.status(HttpStatus.OK).body(ratingServices.getRatingByHotel(hotelId));
    }
}
