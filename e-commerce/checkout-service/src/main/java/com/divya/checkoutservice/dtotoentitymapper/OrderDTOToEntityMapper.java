package com.divya.checkoutservice.dtotoentitymapper;

import com.divya.checkoutservice.dto.ItemDTO;
import com.divya.checkoutservice.dto.OrderDTO;
import com.divya.checkoutservice.entity.ItemEntity;
import com.divya.checkoutservice.entity.OrderEntity;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderDTOToEntityMapper {
//    private ItemDTOToEntityMapper itemDTOToEntityMapper;
//
//    @Autowired
//    public OrderDTOToEntityMapper(ItemDTOToEntityMapper itemDTOToEntityMapper) {
//        this.itemDTOToEntityMapper = itemDTOToEntityMapper;
//    }

    private final ItemDTOToEntityMapper itemDTOToEntityMapper;

    public OrderDTOToEntityMapper() {
        itemDTOToEntityMapper = new ItemDTOToEntityMapper();
    }

    //TODO: use map struct instead of manual mapping
    public OrderEntity map(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderDTO.getId());
        orderEntity.setCustomerName(orderDTO.getCustomerName());
        List<ItemEntity> itemEntityList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(orderDTO.getItems())) {
            for (ItemDTO itemDTO : orderDTO.getItems()) {
                ItemEntity itemEntity = itemDTOToEntityMapper.map(itemDTO);
                itemEntityList.add(itemEntity);
                itemEntity.setOrder(orderEntity);
            }
            orderEntity.setTotalQuantity(orderDTO.getItems().stream().mapToInt(value -> value.getQuantity()).sum());
        }
        orderEntity.setItems(itemEntityList);
        orderEntity.setStatus(orderDTO.getStatus());
        return orderEntity;
    }
}
