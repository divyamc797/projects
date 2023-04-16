package com.divya.springschedulerdemo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "customer_table")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "customerName")
    private String name;
}
