package com.microservices.ratingservice.service.imple;

import com.microservices.ratingservice.entities.Rating;
import com.microservices.ratingservice.repository.RatingRepository;
import com.microservices.ratingservice.service.RatingServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImple implements RatingServices {

    @Autowired
    private RatingRepository ratingRepository;
    @Override
    public Rating createRatings(Rating rating) {
        String RandomRatings=UUID.randomUUID().toString();
        rating.setRatingId(RandomRatings);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsByUser(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotel(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
