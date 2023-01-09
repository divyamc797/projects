package com.divya.checkoutservice.entitytodtomapper;

import com.divya.checkoutservice.dto.ItemDTO;
import com.divya.checkoutservice.dto.OrderDTO;
import com.divya.checkoutservice.entity.ItemEntity;
import com.divya.checkoutservice.entity.OrderEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderEntityToDTOMapper {

//    private ItemEntityToDTOMapper itemEntityToDTOMapper;
//
//    public OrderEntityToDTOMapper(ItemEntityToDTOMapper itemEntityToDTOMapper) {
//        this.itemEntityToDTOMapper = itemEntityToDTOMapper;
//    }

    private final ItemEntityToDTOMapper itemEntityToDTOMapper;

    public OrderDTO map(OrderEntity orderEntity) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(orderEntity.getId());
        orderDTO.setCustomerName(orderEntity.getCustomerName());
        List<ItemDTO> itemDTOList = new ArrayList<>();
        for (ItemEntity itemEntity : orderEntity.getItems()) {
            ItemDTO itemDTO = itemEntityToDTOMapper.map(itemEntity);
            itemDTOList.add(itemDTO);
        }
        orderDTO.setItems(itemDTOList);
        orderDTO.setStatus(orderEntity.getStatus());
        orderDTO.setTotalQuantity(orderEntity.getTotalQuantity());
        return orderDTO;
    }
}
