package com.divya.hotelmanagement.service.mapper;

import com.divya.hotelmanagement.dto.RoomDTO;
import com.divya.hotelmanagement.entity.RoomEntity;
import org.springframework.beans.BeanUtils;

public class RoomMapper {
    public static RoomEntity convertToEntity(RoomDTO roomDTO){
        RoomEntity roomEntity = new RoomEntity();
        BeanUtils.copyProperties(roomDTO, roomEntity);
        return roomEntity;
    }

    public static RoomDTO convertToDTO(RoomEntity roomEntity){
        RoomDTO roomDTO = new RoomDTO();
        BeanUtils.copyProperties(roomEntity, roomDTO);
        return roomDTO;
    }
}
