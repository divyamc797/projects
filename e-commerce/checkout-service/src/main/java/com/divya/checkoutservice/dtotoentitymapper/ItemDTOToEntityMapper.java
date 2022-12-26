package com.divya.checkoutservice.dtotoentitymapper;

import com.divya.checkoutservice.dto.ItemDTO;
import com.divya.checkoutservice.entity.ItemEntity;
import org.springframework.stereotype.Component;

@Component
public class ItemDTOToEntityMapper {

    public ItemEntity map(ItemDTO itemDTO) {
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDTO.getId());
        itemEntity.setName(itemDTO.getName());
        itemEntity.setQuantity(itemDTO.getQuantity());
        return itemEntity;
    }

}
