package com.divya.ordermanagementservice.EntityToDTOMapper;

import com.divya.ordermanagementservice.dto.ItemDTO;
import com.divya.ordermanagementservice.dto.OrderDTO;
import com.divya.ordermanagementservice.entity.ItemEntity;
import com.divya.ordermanagementservice.entity.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderEntityToDTOMapper {
    private final ItemEntityToDTOMapper itemEntityToDTOMapper;

    public OrderDTO map(OrderEntity orderEntity) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(orderEntity.getId());
        orderDTO.setCustomerName(orderEntity.getCustomerName());
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for (ItemEntity itemEntity : orderEntity.getItems()) {
            ItemDTO itemDTO = itemEntityToDTOMapper.map(itemEntity);
            itemDTOS.add(itemDTO);
        }
        orderDTO.setItems(itemDTOS);
        orderDTO.setStatus(orderEntity.getStatus());
        orderDTO.setTotalQuantity(orderEntity.getTotalQuantity());
        return orderDTO;
    }
}
