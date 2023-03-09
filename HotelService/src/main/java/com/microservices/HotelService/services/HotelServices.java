package com.microservices.HotelService.services;

import com.microservices.HotelService.entities.Hotel;

import java.util.List;

public interface HotelServices {
    //create
    Hotel createHotel(Hotel hotel);

    //get hotels
    List<Hotel> getAllHotels();

    //single hotel get
    Hotel getSingleHotel(String hotelId);
}
