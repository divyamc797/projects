package com.divya.hotelmanagement.service.mapper;

import com.divya.hotelmanagement.dto.HotelDTO;
import com.divya.hotelmanagement.dto.RoomDTO;
import com.divya.hotelmanagement.entity.HotelEntity;

import java.util.List;
import java.util.stream.Collectors;

public class HotelMapper {
    public static HotelEntity convertToEntity(HotelDTO hotelDTO) {
        HotelEntity hotelEntity = new HotelEntity();
        hotelEntity.setName(hotelDTO.getName());
        hotelEntity.setAddress(hotelDTO.getAddress());
//        BeanUtils.copyProperties(hotelDTO, hotelEntity);
        return hotelEntity;
    }

    public static HotelDTO convertToDTO(HotelEntity hotelEntity) {
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setId(hotelEntity.getId());
        hotelDTO.setName(hotelEntity.getName());
        hotelDTO.setAddress(hotelEntity.getAddress());
//        List<RoomDTO> roomDTOS = new ArrayList<>();
//        for (RoomEntity roomEntity : hotelEntity.getRooms()) {
//            RoomDTO roomDTO = new RoomDTO();
//            BeanUtils.copyProperties(roomEntity, roomDTO);
//            roomDTOS.add(roomDTO);
//        }
        List<RoomDTO> roomDTOS = hotelEntity.getRooms()
                .stream()
//                .map(roomEntity -> RoomMapper.convertToDTO(roomEntity))
                .map(RoomMapper::convertToDTO)
                .collect(Collectors.toList());
        hotelDTO.setRoomDTOList(roomDTOS);
        return hotelDTO;
    }

}
