package com.divya.ordermanagementservice.DTOToEntityMapper;

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
public class OrderDTOToEntityMapper {

    private final ItemDTOToEntityMapper itemDTOToEntityMapper;

    public OrderEntity map(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderDTO.getId());
        orderEntity.setCustomerName(orderDTO.getCustomerName());
        List<ItemEntity> itemEntityList = new ArrayList<>();
        for (ItemDTO itemDTO : orderDTO.getItems()) {
            ItemEntity item = itemDTOToEntityMapper.map(itemDTO);
            itemEntityList.add(item);
            item.setOrder(orderEntity);
        }
        orderEntity.setItems(itemEntityList);
        orderEntity.setStatus(orderDTO.getStatus());
        orderEntity.setTotalQuantity(orderDTO.getTotalQuantity());
        return orderEntity;
    }
}
