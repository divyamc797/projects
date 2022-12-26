//package com.divya.checkoutservice.entitytodtomapper;
//
//import com.divya.checkoutservice.dto.GroupItemsDTO;
//import com.divya.checkoutservice.entity.GroupByItemNameEntity;
//import com.divya.checkoutservice.entity.GroupItemsEntity;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//@Component
//public class GroupByItemNameEntityToDTOMapper {
//
//    private final GroupItemsEntityTODTOMapper groupItemsEntityTODTOMapper;
//
//    public GroupByItemNameDTO mapper(GroupByItemNameEntity groupByItemNameEntity) {
//        GroupByItemNameDTO groupByItemNameDTO = new GroupByItemNameDTO();
//        List<GroupItemsDTO> groupItemsDTOS = new ArrayList<>();
//        for (GroupItemsEntity groupItemsEntity : groupByItemNameEntity.getGroupItemsEntities()) {
//            GroupItemsDTO groupItemsDTO = groupItemsEntityTODTOMapper.mapper(groupItemsEntity);
//            groupItemsDTOS.add(groupItemsDTO);
//        }
//        groupByItemNameDTO.setGroupItemsDTOS(groupItemsDTOS);
//        return groupByItemNameDTO;
//    }
//}
