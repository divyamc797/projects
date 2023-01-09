package com.divya.checkoutservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupItemsDTO {
    private String itemName;
    private List<Integer> orderId;
    private int count;
    private int quantity;
}
