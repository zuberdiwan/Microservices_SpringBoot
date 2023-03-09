package com.microservices.UserService.services.Imple;

import com.microservices.UserService.entities.Hotel;
import com.microservices.UserService.entities.Ratings;
import com.microservices.UserService.entities.User;
import com.microservices.UserService.exception.ResourceNotFoundException;
import com.microservices.UserService.repository.UserRepository;
import com.microservices.UserService.services.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImple implements UserService {


   // Logger logger=LogManager.getLogger(UserServiceImple.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;



    @Override
    public User saveUsers(User user) {
        String RandomUserId = UUID.randomUUID().toString();
        user.setUserid(RandomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getSingleUser(String userId) {
     // logger.info("UserServiceImple:getSingleUser started...");
        User users = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User Not Found" + userId));
        //get Ratings from rating API
        //http://localhost:8083/ratings/users/115913cf-0eab-4e99-a5e7-5c9ac3214934
        Ratings[] AllRatings = restTemplate.getForObject(
                         "http://RATING-SERVICE/ratings/users/"+users.getUserid(), Ratings[].class);


        List<Ratings> ratings1 = new ArrayList<>();
        for (Ratings AllRating : AllRatings) {
            ratings1.add(AllRating);
        }


        List<Ratings> RatingList = ratings1.stream().map(ratings -> {
            ResponseEntity<Hotel> HotelEntinty=restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+ratings.getHotelId(), Hotel.class);
            Hotel hotel = HotelEntinty.getBody();

            ratings.setHotel(hotel);
            return ratings;
        }).collect(Collectors.toList());


        users.setRatings(RatingList);
       // logger.info("UserServiceImple:getSingleUser end...");
        return users;



    }
}
