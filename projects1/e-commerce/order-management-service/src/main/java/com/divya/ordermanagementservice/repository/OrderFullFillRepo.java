package com.divya.ordermanagementservice.repository;

import com.divya.ordermanagementservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderFullFillRepo extends JpaRepository<OrderEntity, Integer> {
}
