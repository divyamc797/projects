package com.divya.checkoutservice.service;

import com.divya.checkoutservice.dto.GroupItemsDTO;
import com.divya.checkoutservice.dto.GroupItemsWithOrdersDTO;
import com.divya.checkoutservice.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO create(OrderDTO orderDTO);

    OrderDTO getOrder(int id) throws Exception;

    OrderDTO fullFillOrder(int id);

//    OrderDTO getOrderByItems();

    List<GroupItemsDTO> getGroupByItems();

    List<GroupItemsWithOrdersDTO> getGroupByItemsWithOrderInfo();
}
