package com.divya.springschedulerdemo.repository;

import com.divya.springschedulerdemo.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Integer> {
}
