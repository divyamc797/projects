package com.divya.ordermanagementservice.EntityToDTOMapper;

import com.divya.ordermanagementservice.dto.ItemDTO;
import com.divya.ordermanagementservice.entity.ItemEntity;
import org.springframework.stereotype.Component;

@Component
public class ItemEntityToDTOMapper {
    public ItemDTO map(ItemEntity itemEntity) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(itemEntity.getId());
        itemDTO.setName(itemEntity.getName());
        itemDTO.setQuantity(itemEntity.getQuantity());
        return itemDTO;
    }
}
