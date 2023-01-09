package com.divya.ordermanagementservice.DTOToEntityMapper;

import com.divya.ordermanagementservice.dto.ItemDTO;
import com.divya.ordermanagementservice.entity.ItemEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
