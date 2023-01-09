package com.divya.checkoutservice.dto;

import com.divya.checkoutservice.common.Status;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private int id;
    private String customerName;
    private List<ItemDTO> items;
    private Status status;
    private int totalQuantity;
}
