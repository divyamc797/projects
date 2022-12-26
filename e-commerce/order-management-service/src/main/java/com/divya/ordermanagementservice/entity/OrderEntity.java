package com.divya.ordermanagementservice.entity;

import com.divya.ordermanagementservice.common.Status;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "order_table")
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "customerName")
    private String customerName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ItemEntity> items;

    @Column(name = "status")
    private Status status;

    @Column(name = "totalQuantity")
    private int totalQuantity;
}
