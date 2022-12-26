package com.divya.hotelmanagement.repo;

import com.divya.hotelmanagement.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepo extends JpaRepository<HotelEntity, Integer> {
}
