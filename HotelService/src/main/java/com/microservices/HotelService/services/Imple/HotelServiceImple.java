package com.microservices.HotelService.services.Imple;

import com.microservices.HotelService.entities.Hotel;
import com.microservices.HotelService.exception.ResourceNotFoundException;
import com.microservices.HotelService.repository.HotelRepository;
import com.microservices.HotelService.services.HotelServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImple implements HotelServices {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        String HotelRandomId = UUID.randomUUID().toString();
        hotel.setHotelId(HotelRandomId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getSingleHotel(String hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(
                ()->new ResourceNotFoundException("Hotel Not Found Hotel Id is" + hotelId)
        );
    }
}
