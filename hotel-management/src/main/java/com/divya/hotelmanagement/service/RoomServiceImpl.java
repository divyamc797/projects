package com.divya.hotelmanagement.service;

import com.divya.hotelmanagement.dto.RoomDTO;
import com.divya.hotelmanagement.dto.RoomHotelDTO;
import com.divya.hotelmanagement.entity.HotelEntity;
import com.divya.hotelmanagement.entity.RoomEntity;
import com.divya.hotelmanagement.exception.NoDataFoundException;
import com.divya.hotelmanagement.repo.HotelRepo;
import com.divya.hotelmanagement.repo.RoomRepo;
import com.divya.hotelmanagement.service.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepo roomRepo;

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public RoomDTO createRoom(RoomDTO roomDTO) throws Exception {
        Optional<HotelEntity> optionalHotel = hotelRepo.findById(roomDTO.getHotelId());
        return optionalHotel.map(hotelEntity -> {
            RoomEntity room = RoomMapper.convertToEntity(roomDTO);
            room.setHotel(optionalHotel.get());
            roomRepo.save(room);
            roomDTO.setId(room.getId());
            return roomDTO;
        }).orElseThrow(() -> new NoDataFoundException("hotel id not found" + roomDTO.getHotelId()));
    }

    @Override
    public List<RoomDTO> getAllRooms() {
        List<RoomEntity> roomDetails = roomRepo.findAll();

//        List<RoomDTO> roomDTOS = new ArrayList<>();
//        for(RoomEntity roomEntity:roomDetails){
//            RoomDTO roomDTO = RoomMapper.convertToDTO(roomEntity);
//            roomDTOS.add(roomDTO);
//        }

        Map<Integer, List<RoomEntity>> collect = roomDetails.stream()
                .collect(groupingBy(RoomEntity::getRoomNumber));

        List<RoomHotelDTO> roomDTOS = new ArrayList<>();
        RoomHotelDTO roomHotelDTO = new RoomHotelDTO();


        return roomDetails.stream()
                .map(roomEntity -> RoomMapper.convertToDTO(roomEntity))
                .collect(Collectors.toList());

    }
}
