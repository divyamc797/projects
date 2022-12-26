package com.divya.hotelmanagement.service;

import com.divya.hotelmanagement.dto.HotelDTO;

import java.util.List;

public interface HotelService {
    HotelDTO create(HotelDTO hotelDTO);

    HotelDTO getHotelById(int id) throws Exception;

    List<HotelDTO> getHotels();
}
