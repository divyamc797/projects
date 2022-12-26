package com.divya.checkoutservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupItemsWithOrdersDTO {
    private String itemName;
    private List<OrdersInfoDTO> orders;
    private int totalQuantity;
}
