package com.divya.hotelmanagement.service;

import com.divya.hotelmanagement.dto.HotelDTO;
import com.divya.hotelmanagement.entity.HotelEntity;
import com.divya.hotelmanagement.exception.NoDataFoundException;
import com.divya.hotelmanagement.repo.HotelRepo;
import com.divya.hotelmanagement.service.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public HotelDTO create(HotelDTO hotelDTO) {
        HotelEntity hotelEntity = HotelMapper.convertToEntity(hotelDTO);
        hotelRepo.save(hotelEntity);
        hotelDTO.setId(hotelEntity.getId());
        return hotelDTO;
    }

    @Override
    public HotelDTO getHotelById(int id) throws Exception {
        Optional<HotelEntity> byId = hotelRepo.findById(id);

//        byId.ifPresent(hotelEntity -> {
//            HotelDTO hotelDTO = HotelMapper.convertToDTO(hotelEntity);
//        });

//        Optional<HotelDTO> hotelDTO2 = byId.map(hotelEntity -> {
//            HotelDTO hotelDTO = HotelMapper.convertToDTO(hotelEntity);
//            return hotelDTO;
//        });
//        return hotelDTO2.get();

//        return byId.map(hotelEntity -> {
//            HotelDTO hotelDTO = HotelMapper.convertToDTO(hotelEntity);
//            return hotelDTO;
//        }).orElseThrow(() -> new Exception("gjh"));

//        return byId
//                .map(hotelEntity -> HotelMapper.convertToDTO(hotelEntity))
//                .orElseThrow(() -> new Exception("gjh"));

        return byId
                .map(HotelMapper::convertToDTO)  // works when we pass single param
                .orElseThrow(() -> new NoDataFoundException("No hotel found for the hotel Id passed:" + id));
    }

    @Override
    public List<HotelDTO> getHotels() {
        List<HotelEntity> hotels = hotelRepo.findAll();
        List<HotelDTO> collect = hotels.stream()
                .map(HotelMapper::convertToDTO)
                .collect(Collectors.toList());

        return collect;
    }
}
