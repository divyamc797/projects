package com.divya.hotelmanagement.repo;

import com.divya.hotelmanagement.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepo extends JpaRepository<RoomEntity, Integer> {
}
