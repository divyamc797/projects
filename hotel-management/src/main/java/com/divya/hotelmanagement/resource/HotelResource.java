package com.divya.hotelmanagement.resource;

import com.divya.hotelmanagement.dto.HotelDTO;
import com.divya.hotelmanagement.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotels")
public class HotelResource {

    @Autowired
    private HotelService hotelService;

    @PostMapping()
    public ResponseEntity<?> createHotel(@RequestBody HotelDTO hotelDTO) {
        HotelDTO hotelDTO1 = hotelService.create(hotelDTO);
        return ResponseEntity.ok().body(hotelDTO1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) throws Exception {
        return ResponseEntity.ok().body(hotelService.getHotelById(id));
    }

    @GetMapping()
    public ResponseEntity<?> getAll() throws Exception {
        return ResponseEntity.ok().body(hotelService.getHotels());
    }
}
