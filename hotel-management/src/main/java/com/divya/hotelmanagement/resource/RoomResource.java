package com.divya.hotelmanagement.resource;

import com.divya.hotelmanagement.dto.RoomDTO;
import com.divya.hotelmanagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomResource {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody RoomDTO roomDTO) throws Exception {
        return ResponseEntity.created(null).body(roomService.createRoom(roomDTO));
    }

    @GetMapping
    public ResponseEntity<?> getAllRooms(){
        return ResponseEntity.ok().body(roomService.getAllRooms());
    }

}
