package com.divya.hotelmanagement.service;

import com.divya.hotelmanagement.dto.RoomDTO;

import java.util.List;

public interface RoomService {
    RoomDTO createRoom(RoomDTO roomDTO) throws Exception;

    List<RoomDTO> getAllRooms();
}
