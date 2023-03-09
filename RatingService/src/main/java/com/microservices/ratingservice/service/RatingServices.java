package com.microservices.ratingservice.service;

import com.microservices.ratingservice.entities.Rating;

import java.util.List;

public interface RatingServices {
    //create
    Rating createRatings(Rating rating);

    //get all ratings
    List<Rating> getAllRatings();

    //get single rating
    List<Rating> getRatingsByUser(String userId);

    //get all hotels
    List<Rating> getRatingByHotel(String hotelId);

}
